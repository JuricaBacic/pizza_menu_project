package org.example.repository

import org.example.NodeEntity.Pizza


interface PizzaRepository : Neo4jRepository<Pizza, Long> {

}