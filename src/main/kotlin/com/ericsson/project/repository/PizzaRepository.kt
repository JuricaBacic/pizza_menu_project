package com.ericsson.project.repository

import com.ericsson.project.NodeEntity.Pizza
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface PizzaRepository : Neo4jRepository<Pizza, Long> {

    fun findAllById(id: Long): Pizza

}