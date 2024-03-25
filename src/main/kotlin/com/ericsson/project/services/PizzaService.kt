package com.ericsson.project.services

import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.repository.PizzaRepository
import com.ericsson.project.repository.ToppingRepository
import org.example.models.PizzaOrderRequestModel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PizzaService(
    private val pizzaRepository: PizzaRepository,
    private val crustService: CrustService,
    private val toppingService: ToppingService
) {
    companion object {
        const val CUSTOM_PIZZA_NAME = "Custom Pizza"
    }
    fun findAllPizzaOnMenu(): List<Pizza> = pizzaRepository.findAll()
    fun getPizzaById(id: Long): Pizza? {
       return pizzaRepository.findAllById(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "Pizza not found by specific id"
        )
    }
    fun getAllPizzaByIds(ids: List<Long>): List<Pizza>? {
        return pizzaRepository.findAllPizzaByIds(ids) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "There is no pizza with this ids"
        )
    }

    fun placePizzaOrder(pizzaOrderRequest: PizzaOrderRequestModel): Pizza {
        val crust = pizzaOrderRequest.crustType?.type?.let { crustType ->
            pizzaOrderRequest.crustSize?.size?.let { crustSize ->
            crustService.getCrustByTypeAndSize(crustType, crustSize)
        } } ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid crust size or type.")

        val toppings = pizzaOrderRequest.toppings?.map { name ->
            toppingService.findToppingByName(name)
        }

        val pizza = Pizza(
            name = CUSTOM_PIZZA_NAME,
            crust = crust,
            toppings = toppings
        )
        return pizzaRepository.save(pizza)
    }
}