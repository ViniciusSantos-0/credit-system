package com.apikotlin.creditrequestsystem.service.impl

import com.apikotlin.creditrequestsystem.entity.Customer
import com.apikotlin.creditrequestsystem.exception.BusinessException
import com.apikotlin.creditrequestsystem.repository.CustomerRepository
import com.apikotlin.creditrequestsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer {
        return   this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw BusinessException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
       val customer: Customer = this.findById(id)
       this.customerRepository.delete(customer);
    }
}