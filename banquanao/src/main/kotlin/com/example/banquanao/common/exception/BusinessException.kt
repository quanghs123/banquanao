package com.example.banquanao.common.exception

class BusinessException : RuntimeException {
    val messageId: String
    val params: Array<String>

    constructor(messageId: String) : super() {
        this.messageId = messageId
        this.params = arrayOf()
    }

    constructor(messageId: String, message: String) : super(message) {
        this.messageId = messageId
        this.params = arrayOf()
    }

    constructor(messageId: String, params: Array<String>) : super() {
        this.messageId = messageId
        this.params = params
    }

    override fun toString(): String {
        return super.toString() + ", messageId=$messageId"
    }
}