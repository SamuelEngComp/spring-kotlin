package br.com.springkotlin.springkotlin.controller

import br.com.springkotlin.springkotlin.model.Person
import br.com.springkotlin.springkotlin.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/person"])
class PersonController {

    @Autowired
    private lateinit var servicePerson: PersonService


    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person>{
        return servicePerson.findAll()
    }

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value = "id") id: Long): Person{
        return servicePerson.findById(id = id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createPerson(@RequestBody person: Person): Person{
        return servicePerson.createPerson(person = person)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updatePerson(@RequestBody person: Person): Person{
        return servicePerson.updatePerson(person = person)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deletePerson(@PathVariable(value = "id") id: Long) : ResponseEntity<*>{
        servicePerson.deletePerson(id = id)
        return ResponseEntity.noContent().build<Any>()
    }


}