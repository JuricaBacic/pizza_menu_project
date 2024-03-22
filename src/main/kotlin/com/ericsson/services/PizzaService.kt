package org.example.services

import org.example.NodeEntity.Pizza
import org.example.repository.PizzaRepository

@Service
class PizzaService(private val pizzaRepository: PizzaRepository) {
    fun getAllPizzas(): Iterable<Pizza> = pizzaRepository.findAll()
    fun getPizzaById(id: Long): Pizza? = pizzaRepository.(id).orElse(null)
    fun createOrUpdatePizza(pizza: Pizza): Pizza = pizzaRepository.save(pizza)
}