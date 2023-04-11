package com.apikotlin.creditrequestsystem.service

import com.apikotlin.creditrequestsystem.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}