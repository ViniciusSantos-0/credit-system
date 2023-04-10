package com.apikotlin.creditrequestsystem.entity

import java.math.BigDecimal

data class Customer(
    val id: Long? = null,
    var firstName: String = "",
    var lastName: String = "",
    val cpf: String,
    var email: String = "",
    var password: String = "",
    var address: Address = Address(),
    var income: BigDecimal,
    var credits: List<Credit> = mutableListOf()

)
