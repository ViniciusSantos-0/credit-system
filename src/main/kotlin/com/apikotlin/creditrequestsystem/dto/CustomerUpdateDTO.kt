package com.apikotlin.creditrequestsystem.dto

import com.apikotlin.creditrequestsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDTO(
    val fisrtName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {

    fun toEntity(customer: Customer): Customer{
        customer.firstName = this.fisrtName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}
