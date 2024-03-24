package com.ericsson.project.services

import com.ericsson.project.CrustType
import com.ericsson.project.NodeEntity.Crust
import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.NodeEntity.Topping
import com.ericsson.project.enums.CrustSize
import com.ericsson.project.enums.ToppingsName
import com.ericsson.project.repository.PizzaRepository
import org.example.models.PizzaModel
import org.springframework.stereotype.Service

@Service
class PizzaService(private val pizzaRepository: PizzaRepository) {
    fun findAllPizzaOnMenu(): List<Pizza> = pizzaRepository.findAll()
    fun getPizzaById(id: Long): Pizza = pizzaRepository.findAllById(id)
    fun create(pizza: PizzaModel): Pizza {

       val newPizza = Pizza(
           name = pizza.name ?: "Custom Pizza",
           crust = Crust(size = CrustSize.entries.toTypedArray().toString(), type = CrustType.entries.toTypedArray().toString()),
           toppings = listOf(Topping(name = ToppingsName.ONIONS.name)))

        return pizzaRepository.save(newPizza)
    }
}