package org.example.models

import com.ericsson.project.enums.CrustSize
import com.ericsson.project.enums.CrustType
import com.ericsson.project.enums.ToppingsName
data class PizzaModel(
    var name: String? = null,
    var crustType: CrustType? = null,
    var crustSize: CrustSize? = null,
    var topping: List<ToppingsName>? = null
)