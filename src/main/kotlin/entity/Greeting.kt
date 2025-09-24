package es.unizar.webeng.hello.entity

import jakarta.persistence.*
import java.time.LocalDateTime


//Entidad para guardar los saludos en la base de datos
@Entity
@Table(name = "greetings")
class Greeting() {

    //ID para cada saludo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    //Nombre de la persona que saluda
    var name: String = ""


    //Define cuando se realizó el saludo
    var timestamp: LocalDateTime = LocalDateTime.now()

    //Genera un saludo con nombre y timeStamp temporal
    constructor(name: String, timestamp: LocalDateTime = LocalDateTime.now()) : this() {
        this.name = name
        this.timestamp = timestamp
    }
}
