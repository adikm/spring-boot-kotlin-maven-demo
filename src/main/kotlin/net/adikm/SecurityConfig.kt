package net.adikm

import mu.KLogging
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        logger.info { "Security initialization" }

        http.authorizeRequests().anyRequest().permitAll().and().httpBasic()
    }

    companion object : KLogging()
}
