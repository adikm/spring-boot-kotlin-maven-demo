package net.adikm

import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class DemoController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<Person> {
        logger.info("Returning list of Person objects")

        return listOf(Person("John", "Doe", 12), Person("Amanda", "Doe", 14))
    }

    companion object : KLogging()

}
