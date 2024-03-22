package org.example.models

import org.example.enums.CrustType
import org.example.enums.ToppingsName

data class PizzaConfigurationModel(
    var pizzaId: Long,
    var crustType: CrustType,
    var topping: List<ToppingsName>
)