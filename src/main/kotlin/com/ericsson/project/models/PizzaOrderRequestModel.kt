package org.example.models

import com.ericsson.project.enums.CrustSize
import com.ericsson.project.enums.CrustType
import com.ericsson.project.enums.ToppingsName

data class PizzaOrderRequestModel(
    var crustType: CrustType? = null,
    var crustSize: CrustSize? = null,
    var toppings: List<ToppingsName>? = null
)
