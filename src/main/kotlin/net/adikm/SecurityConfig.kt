package net.adikm

import mu.KLogging
import org.springframework.context.annotation.*
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun springWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        logger.info { "Security initialization" }

        return http
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET, "/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .build()
    }

    companion object : KLogging()
}
