package net.adikm

import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/persons")
class PersonController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): Flux<Person> {
        logger.info { "Returning list of Person objects" }

        return Flux.just(Person("John", "Doe", 12), Person("Amanda", "Doe", 14))
    }

    companion object : KLogging()

}
