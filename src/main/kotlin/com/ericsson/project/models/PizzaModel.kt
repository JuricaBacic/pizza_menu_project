package org.example.models

import com.ericsson.project.enums.CrustType
import com.ericsson.project.enums.ToppingsName
data class PizzaModel(
    var pizzaId: Long,
    var crustType: CrustType,
    var topping: List<ToppingsName>
)