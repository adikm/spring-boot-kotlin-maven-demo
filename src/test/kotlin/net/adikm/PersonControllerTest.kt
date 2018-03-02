package net.adikm

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.*


@RunWith(SpringRunner::class)
@WebFluxTest
class PersonControllerTest {

    @Autowired
    private lateinit var webClient: WebTestClient

    @Test
    fun getAllTest() {
        val expectedJson = """[{"firstName":"John","lastName":"Doe","age":12},{"firstName":"Amanda","lastName":"Doe","age":14}]"""

        val bodySpec: WebTestClient.BodySpec<String, *> = webClient.get().uri("/persons")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody(String::class.java)

        assertEquals(expectedJson, bodySpec.returnResult().responseBody)
    }

}
