package org.example.NodeEntity

@NodeEntity
data class Pizza(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String,
    var price: Double,
    @Relationship(type = "HAS_CRUST")
    var crust: Crust,
    @Relationship(type = "HAS_TOPPING")
    var toppings: List<Topping>
)
