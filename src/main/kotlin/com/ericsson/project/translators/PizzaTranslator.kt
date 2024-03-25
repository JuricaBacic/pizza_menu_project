package com.ericsson.project.translators

import com.ericsson.project.enums.CrustSize
import com.ericsson.project.enums.CrustType
import com.ericsson.project.enums.ToppingsName
import org.example.models.PizzaOrderRequestModel

fun PizzaOrderRequestWrapper.toModel(): PizzaOrderRequestModel = PizzaOrderRequestModel(
   crustType = crustType,
    crustSize = crustSize,
    toppings = toppings
)

data class PizzaOrderRequestWrapper(
    var crustType: CrustType? = null,
    var crustSize: CrustSize? = null,
    var toppings: List<ToppingsName>? = null
)
