package es.unizar.webeng.hello.service

import es.unizar.webeng.hello.repository.GreetingRepository
import es.unizar.webeng.hello.entity.Greeting
import org.springframework.stereotype.Service

//Encapsula logica de negocio para los saludos
@Service
class GreetingService(private val GreetingRepository: GreetingRepository) {


    //Devuelve la lista completa de saludos almacenados en la base de datos
    fun getHistory(): List<Greeting> {
        return GreetingRepository.findAll()
    }

    //Crea un nuevo saludo con el nombre proporcionado y lo guarda en la base de datos
    fun saveGreeting(name: String): Greeting {
        val greeting = Greeting( name = name)
        return GreetingRepository.save(greeting)
    }
}