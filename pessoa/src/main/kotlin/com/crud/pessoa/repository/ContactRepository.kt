package com.crud.pessoa.repository

import com.crud.pessoa.model.Contact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository: JpaRepository<Contact, Long> {
    abstract fun save(contact: Contact?)


}