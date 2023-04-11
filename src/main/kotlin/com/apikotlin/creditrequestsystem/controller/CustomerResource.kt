package com.apikotlin.creditrequestsystem.controller

import com.apikotlin.creditrequestsystem.dto.CustomerDTO
import com.apikotlin.creditrequestsystem.dto.CustomerUpdateDTO
import com.apikotlin.creditrequestsystem.dto.CustomerView
import com.apikotlin.creditrequestsystem.entity.Customer
import com.apikotlin.creditrequestsystem.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerResource (
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDTO: CustomerDTO): ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} Savid!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long ): ResponseEntity<CustomerView> {
     val customer : Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long){
        this.customerService.delete(id);
    }

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customer.id") id: Long, @RequestBody customerUpdateDTO: CustomerUpdateDTO): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(this.customerService.save(customerUpdateDTO.toEntity(customer))))
    }
}