package com.example.formula1

import java.lang.RuntimeException
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class PostgresConnection {
    lateinit var connection: Connection
    init {

        try {
            Class.forName("org.postgresql.Driver")
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.0.250:5432/formula1", "postgres", "senhasupersegura123")
            println("conexão: ")
        }catch (e: SQLException){
            e.printStackTrace()
            println("servidor de banco de dados não encontrado!" + e.message)
        }



    }
}