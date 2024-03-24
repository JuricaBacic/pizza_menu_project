package com.ericsson.project.NodeEntity

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Pizza(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String? = null,
    @Relationship(type = "HAS_CRUST", direction = Relationship.Direction.OUTGOING)
    var crust: Crust? = null,
    @Relationship(type = "HAS_TOPPING", direction = Relationship.Direction.OUTGOING)
    var toppings: List<Topping>? = null
)