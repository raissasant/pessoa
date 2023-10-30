package com.crud.pessoa.controller

import com.crud.pessoa.model.Contact
import com.crud.pessoa.repository.ContactRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contacts")
class ContactController {
    @Autowired
    lateinit var repository: ContactRepository

    @GetMapping
    fun listar(): List<Contact> {
        return repository.findAll()
    }

    @PostMapping
    fun create (@RequestBody contact: Contact) {
        return repository.save(contact)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id:Long): Contact {
        return repository.findById(id).orElseThrow {  EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody newContact: Contact) {
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException() }

        contact.apply {
            this.nome = newContact.nome
            this.email = newContact.email
            this.cidade = newContact.cidade
            this.telefone = newContact.telefone
        }

        return repository.save(contact)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(contact)
    }
}