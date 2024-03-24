package com.ericsson.project.repository

import com.ericsson.project.NodeEntity.Crust
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface CrustRepository : Neo4jRepository<Crust, Long> {
    fun findByTypeAndSize(type: String, size: String): List<Crust>
}