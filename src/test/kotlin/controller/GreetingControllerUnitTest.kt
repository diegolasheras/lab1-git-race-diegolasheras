package es.unizar.webeng.hello.controller

import es.unizar.webeng.hello.entity.Greeting
import es.unizar.webeng.hello.service.GreetingService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.context.bean.override.mockito.MockitoBean

import org.springframework.test.web.servlet.MvcResult

@WebMvcTest(GreetingAppiController::class, GreetingWebController::class) 
class GreetingControllerUnitTest(
    // Se usa para simular peticiones HTTP (GET, POST, etc.) sin levantar un servidor real.
    @Autowired private val mockMvc: MockMvc
) {
    
    @MockitoBean private lateinit var greetingService: GreetingService


    @Test
    fun `should return stats view`() {
        // Simula una petición HTTP GET al endpoint "/stats".
        mockMvc.perform(get("/stats"))
            .andExpect(status().isOk)
            .andExpect(view().name("stats"))
            }

    @Test
    fun `should return save greeting`() {
        val saved = Greeting("Diego")

        // Comportamiento a "simular" (mockear)
        `when`(
            //any para acepatar cualquier string.
            greetingService.saveGreeting(any(String::class.java) ?: "")
        )
        //Lo que debe devolver el metodo simulado
        .thenReturn(saved)

        val result: MvcResult = mockMvc.perform(get("/api/greeting/save").param("name", "Diego"))
        .andExpect(status().isOk)
        .andReturn() // devuelve el resultado para usarlo

        val responseBody = result.response.contentAsString
        println("JSON Response: $responseBody")


        //Llamada al endpoint
        mockMvc.perform(get("/api/greeting/save").param("name", "Diego"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.message").value("Hello, Diego!"))
            .andExpect(jsonPath("$.timestamp").exists())
    }

    @Test
    fun `should return history greeting`() {
        val history = listOf(Greeting("Lasheras"),  
                        Greeting("Blasco"))


        // Comportamiento a "simular" (mockear)
        `when`(
            //any para acepatar cualquier string.
            greetingService.getHistory()
        )
        //Lo que debe devolver el metodo simulado
        .thenReturn(history)

        //Llamada al endpoint
        mockMvc.perform(get("/api/greeting/history"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Lasheras"))
            .andExpect(jsonPath("$[0].timestamp").exists())
            .andExpect(jsonPath("$[1].name").value("Blasco"))
            .andExpect(jsonPath("$[1].timestamp").exists())
    }
}

