package com.ericsson.project.repository

import com.ericsson.project.NodeEntity.Pizza
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface PizzaRepository : Neo4jRepository<Pizza, Long> {
    fun findAllById(id: Long): Pizza?
    @Query("MATCH (pizza:Pizza) WHERE id(pizza) IN \$ids RETURN pizza")
    fun findAllPizzaByIds(ids: List<Long>): List<Pizza>?
}