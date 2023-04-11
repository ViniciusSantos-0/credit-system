package com.apikotlin.creditrequestsystem.dto

import com.apikotlin.creditrequestsystem.entity.Credit
import com.apikotlin.creditrequestsystem.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    @field:NotNull(message = "Invalid input")
    val creditValue: BigDecimal,

    @field:Future
    val dayFirstOfInstallment: LocalDate,

    @field:NotNull(message = "Invalid input")
    val numberOfInstallment: Int,

    @field:NotNull(message = "Invalid input")
    val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )


}
