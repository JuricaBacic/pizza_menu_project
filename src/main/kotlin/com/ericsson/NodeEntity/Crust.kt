package org.example.NodeEntity

@NodeEntity
data class Crust(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var type: String,
    var size: String
)
