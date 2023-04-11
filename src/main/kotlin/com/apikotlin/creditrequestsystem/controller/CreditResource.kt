package com.apikotlin.creditrequestsystem.controller

import com.apikotlin.creditrequestsystem.dto.CreditDTO
import com.apikotlin.creditrequestsystem.dto.CreditView
import com.apikotlin.creditrequestsystem.dto.CreditViewList
import com.apikotlin.creditrequestsystem.entity.Credit
import com.apikotlin.creditrequestsystem.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(creditDto: CreditDTO):ResponseEntity<String> {
       val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllbyCustomerId(@RequestParam(value = "customerId") customerId: Long):ResponseEntity <List<CreditViewList>>{
       val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream().map { credit: Credit -> CreditViewList(credit)}
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long, @PathVariable creditCode: UUID) : ResponseEntity<CreditView> {
       val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}