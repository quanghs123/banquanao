package com.example.banquanao.common.handler

import com.example.banquanao.common.exception.BusinessException
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
//import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@RestControllerAdvice
class ExceptionHandle(private val messageSource: MessageSource) : ResponseEntityExceptionHandler() {
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any> {
        val body = mapOf(
            "errors" to ex.bindingResult.fieldErrors.map { e ->
                mapOf(
                    "defaultMessage" to e.defaultMessage,
                    "field" to e.field
                )
            },
            "path" to (request as? ServletWebRequest)?.request?.requestURI
        )
        return handleExceptionInternal(ex, body, HttpHeaders(), HttpStatus.BAD_REQUEST, request)!!
    }

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(ex: AccessDeniedException, request: WebRequest): ResponseEntity<Any> {
        logger.error("UnAuthorized error occurred.", ex)
        return super.handleExceptionInternal(
            ex,
            mapOf("message" to ex.message),
            HttpHeaders(),
            HttpStatus.UNAUTHORIZED,
            request
        )!!
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException, request: WebRequest): ResponseEntity<Any> {
        val errorException = BusinessException(ex.messageId, getMessage(ex.messageId, ex.params))
        logger.error("BusinessException error occurred.", ex)
        return handleExceptionInternal(
            errorException,
            createErrorResponse(ex.messageId, ex.params),
            HttpHeaders(),
            HttpStatus.INTERNAL_SERVER_ERROR,
            request
        )!!
    }

    @ExceptionHandler(Exception::class)
    fun handle(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        logger.error("Internal error occurred.", ex)
        return handleExceptionInternal(
            ex,
            mapOf("message" to ex.message),
            HttpHeaders(),
            HttpStatus.INTERNAL_SERVER_ERROR,
            request
        )!!
    }

    private fun createErrorResponse(messageId: String, params: Array<String>?): MutableMap<String, String> {
        val errorInfoMaps: MutableMap<String, String> = mutableMapOf()
        errorInfoMaps += mapOf("timestamp" to LocalDateTime.now().toString())
        errorInfoMaps += mapOf("status" to "C200")
        errorInfoMaps += mapOf("errortype" to "BusinessException")
        errorInfoMaps += mapOf("message" to getMessage(messageId, params))
        return errorInfoMaps
    }

    private fun getMessage(messageId: String, params: Array<String>?): String {
        return messageSource.getMessage(messageId, params, LocaleContextHolder.getLocale())
    }
}