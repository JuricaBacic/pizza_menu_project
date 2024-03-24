package com.ericsson.project.services

import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.repository.PizzaRepository
import org.springframework.stereotype.Service

@Service
class PizzaService(private val pizzaRepository: PizzaRepository) {
    fun findAllPizzaOnMenu(): List<Pizza> = pizzaRepository.findAll()
    fun getPizzaById(id: Long): Pizza = pizzaRepository.findAllById(id)
    fun createOrUpdatePizza(pizza: Pizza): Pizza = pizzaRepository.save(pizza)
}