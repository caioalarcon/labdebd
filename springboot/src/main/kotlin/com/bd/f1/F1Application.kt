package com.bd.f1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@EntityScan("com.bd.f1.model")
@EnableJpaRepositories("com.bd.f1.repository")

class F1Application

fun main(args: Array<String>) {
    runApplication<F1Application>(*args)
}
