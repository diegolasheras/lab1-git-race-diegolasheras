package es.unizar.webeng.hello.controller

import es.unizar.webeng.hello.entity.Greeting
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles

import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.test.web.server.LocalServerPort


//  @SpringBootTest Inica el contesto de la aplicación (controladores, servicios y capa de persistencia)
@ActiveProfiles("test") 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GreetingControllerIntegrationTest {


    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `should save a greeting in the database`() {
        val saved = "Diego"

        val response = restTemplate.getForEntity("/api/greeting/save?name=$saved", Greeting::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertNotNull(response.body)
    
        assertEquals("Hello, Diego!", response.body?.message)
        assertNotNull(response.body?.timestamp)
    }


    @Test
    fun `should return history from DB`() {
        //Se guardan dos saludos
        restTemplate.getForEntity("/api/greeting/save?name=Lasheras", Greeting::class.java)
        restTemplate.getForEntity("/api/greeting/save?name=Blasco", Greeting::class.java)

        //Se recuperan de la base
        val response = restTemplate.getForEntity("/api/greeting/history", Array<Greeting>::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertNotNull(response.body)
    
        assertEquals(2, response.body?.size)
        assertEquals("Lasheras", response.body?.get(0)?.name)
        assertEquals("Blasco", response.body?.get(1)?.name)

    }

}


