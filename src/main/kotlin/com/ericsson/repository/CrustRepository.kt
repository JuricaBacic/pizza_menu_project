package org.example.repository

import org.example.NodeEntity.Crust

interface CrustRepository : Neo4jRepository<Crust, Long> {
}