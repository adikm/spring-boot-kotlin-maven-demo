package net.adikm

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import kotlin.test.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerTest {

    @Autowired private lateinit var ctx: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @BeforeTest
    fun setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build()
    }

    @Test
    fun getAllTemplates() {
        val result = this.mockMvc.perform(get("/persons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)

        val expectedJson = """[{"firstName":"John","lastName":"Doe","age":12},{"firstName":"Amanda","lastName":"Doe","age":14}]"""

        assertEquals(expectedJson, result.andReturn().response.contentAsString)
    }

}