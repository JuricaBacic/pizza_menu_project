package org.example.NodeEntity

@NodeEntity
data class Topping(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String
)

