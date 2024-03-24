package com.ericsson.project.NodeEntity

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class Topping(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String
)

