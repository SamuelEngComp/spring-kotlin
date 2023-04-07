package br.com.springkotlin.springkotlin.services

import br.com.springkotlin.springkotlin.model.Person
import br.com.springkotlin.springkotlin.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    fun findAll(): List<Person> = repository.findAll()

    fun findById(id: Long): Person {
        return repository.findById(id).orElseThrow()
    }

    fun createPerson(person: Person) : Person{
       return repository.save(person)
    }

    fun updatePerson(person: Person): Person{

        val entity = repository.findById(person.id)
            .orElseThrow()

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return repository.save(entity)
    }

    fun deletePerson(id: Long){
        val entity = repository.findById(id)
            .orElseThrow()

        repository.delete(entity)

    }


}