package es.unizar.webeng.hello.controller

import es.unizar.webeng.hello.service.GreetingService
import es.unizar.webeng.hello.entity.Greeting
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


//Controlador para manejar peticiones HTML
@Controller
class GreetingWebController(private val GreetingService: GreetingService) {
    

    @GetMapping("/stats")
    fun showStatsPage(): String {
        return "stats"
        }
    }
    

// Controlador REST para guardar un saludo y devolver el historial de saludos guardados
@RestController
class GreetingAppiController(private val GreetingService : GreetingService) {
    @GetMapping("/api/greeting/history") 
    fun getHistory(): List<Greeting> {
        return GreetingService.getHistory()
    }

    @GetMapping("/api/greeting/save") 
    fun saveGreeting(@RequestParam name: String): Map<String, String> {
        val saved = GreetingService.saveGreeting(name)
            return mapOf(
            "message" to "Hello, ${saved.name}!",
            "timestamp" to saved.timestamp.toString()
        )
    }
}