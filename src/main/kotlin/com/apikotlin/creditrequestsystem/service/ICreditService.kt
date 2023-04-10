package com.apikotlin.creditrequestsystem.service

import com.apikotlin.creditrequestsystem.entity.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customeeId: Long):List<Credit>

    fun findByCreditCode(customeeId: Long, creditCode:UUID): Credit
}