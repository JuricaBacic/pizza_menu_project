package com.ericsson.project.repository

import com.ericsson.project.NodeEntity.Topping
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface ToppingRepository : Neo4jRepository<Topping, Long> {}