package org.example.repository

import org.example.NodeEntity.Topping

interface ToppingRepository : Neo4jRepository<Topping, Long> {
}