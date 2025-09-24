package es.unizar.webeng.hello.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "greetings")
class Greeting() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String = ""

    var timestamp: LocalDateTime = LocalDateTime.now()

    constructor(name: String, timestamp: LocalDateTime = LocalDateTime.now()) : this() {
        this.name = name
        this.timestamp = timestamp
    }
}
