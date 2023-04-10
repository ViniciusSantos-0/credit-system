package com.apikotlin.creditrequestsystem.entity

import com.apikotlin.creditrequestsystem.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class Credit (
    val id : Long? = null,
    val creditCode: UUID = UUID.randomUUID(),
    val creditValue: BigDecimal = BigDecimal.ZERO,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int = 0,
    val status: Status = Status.IN_PROGRESS,
    val customer: Customer? = null
)