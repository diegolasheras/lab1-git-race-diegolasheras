package es.unizar.webeng.hello.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import es.unizar.webeng.hello.entity.Greeting

//Repositorio para manejar operaciones CRUD
@Repository
interface GreetingRepository : JpaRepository<Greeting, Long>