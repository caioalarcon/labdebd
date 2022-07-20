package com.bd.f1.controller



import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@CrossOrigin(maxAge = 3600)
@RestController
class AppsController(
) {

    @GetMapping("/")
    @ResponseBody
    fun helloWorld(): ResponseEntity<Any?> {
        return ResponseEntity("Hello World", HttpStatus.OK)
    }


}