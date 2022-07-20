package com.bd.f1.controller



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
        return ResponseEntity("ainda estou funcionando", HttpStatus.OK)
    }


}