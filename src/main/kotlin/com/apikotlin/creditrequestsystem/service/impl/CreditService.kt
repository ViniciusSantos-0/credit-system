package com.apikotlin.creditrequestsystem.service.impl

import com.apikotlin.creditrequestsystem.entity.Credit
import com.apikotlin.creditrequestsystem.repository.CreditRepository
import com.apikotlin.creditrequestsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
       return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customeeId: Long): List<Credit> {
     return this.creditRepository.findAllByCustomer(customeeId)
    }

    override fun findByCreditCode(customeeId: Long, creditCode: UUID): Credit {
      val credit: Credit =  (this.creditRepository.findByCreditCode(creditCode)
            ?: throw  RuntimeException("CreditCode $creditCode not found"))
        return if(credit.customer?.id == customeeId) credit else throw IllegalArgumentException("contact admin")
    }
}