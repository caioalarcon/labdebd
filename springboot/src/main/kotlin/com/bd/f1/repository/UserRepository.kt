package com.bd.f1.repository

import com.bd.f1.model.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource


@RepositoryRestResource(collectionResourceRel = "user", path = "users")
interface UserRepository : PagingAndSortingRepository<User?, Long?> {
    fun findByLogin(@Param("login") login: String?): List<User?>?
    @Query("SELECT c.login FROM User c where c.userid = :userid")
    fun findLoginByUserid(@Param("Userid") Userid: Long?): User?


    fun findByLoginOrderByLogin(@Param("Login") name: String?): List<User?>?
}
