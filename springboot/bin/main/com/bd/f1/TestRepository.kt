package com.bd.f1


import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource


@RepositoryRestResource(collectionResourceRel = "user", path = "users")
interface TestRepository : PagingAndSortingRepository<Cliente?, Long?> {

    fun findByNome(@Param("Login") name: String?): List<Cliente?>?


    @Query("SELECT c.nome FROM Cliente c where c.id = :id")
    fun findNomeById(@Param("id") id: Long?): Cliente?

    
    fun findByNomeOrderByNome(@Param("name") name: String?): List<Cliente?>?
}