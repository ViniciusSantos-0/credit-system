package com.apikotlin.creditrequestsystem.repository

import com.apikotlin.creditrequestsystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}