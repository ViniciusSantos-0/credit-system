package com.apikotlin.creditrequestsystem.exception

data class BusinessException(override val message: String?): RuntimeException(message) {
}