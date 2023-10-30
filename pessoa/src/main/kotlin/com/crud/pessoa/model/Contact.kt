package com.crud.pessoa.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


    @Entity
    @Table(name = "contacts")

    class Contact (
        @field: Id
        @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,


        @field:NotNull
        @field:Size(min = 5, max = 50)
        var nome: String,

        @field:NotNull
        @field:Email
        var email: String,

        @field:NotNull
        @field:Size()
        var cidade: String,

        @field:NotNull
        @field:Size()
        var telefone: String
    ) {

    }




