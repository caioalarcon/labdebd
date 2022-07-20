package com.bd.f1

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class F1DBRepository {
    private val dbUrl = "jdbc:postgresql://localhost:5432/formula1"
    private val dbUser = "postgres"
    private val dbPass = "abex55736060"
    init {
        Database.connect(dbUrl, driver = "org.postgresql.Driver", user = dbUser, password = dbPass)
        createUsersTable()
    }
    fun createUsersTable(){
        transaction {
            addLogger(StdOutSqlLogger)

        }
    }

}