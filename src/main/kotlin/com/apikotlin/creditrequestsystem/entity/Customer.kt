package com.apikotlin.creditrequestsystem.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "Customer")
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var firstName: String = "",

    @Column(nullable = false)
    var lastName: String = "",

    @Column(nullable = false, unique = true)
    val cpf: String,

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    var address: Address = Address(),

    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
        mappedBy = "customer")
    @Column(nullable = false)
    var credits: List<Credit> = mutableListOf()

)
