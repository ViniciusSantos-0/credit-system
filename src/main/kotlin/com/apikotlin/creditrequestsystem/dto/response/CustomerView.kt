package com.apikotlin.creditrequestsystem.dto.response

import com.apikotlin.creditrequestsystem.entity.Address
import com.apikotlin.creditrequestsystem.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String,
    val id: Long?
) {
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        password = customer.password,
        zipCode = customer.address.zipCode,
        street = customer.address.street,
        id = customer.id
        )
    }


