package com.ericsson.project

import com.ericsson.project.Controller.PizzaController
import com.ericsson.project.NodeEntity.Crust
import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.NodeEntity.Topping
import com.ericsson.project.repository.PizzaRepository
import com.ericsson.project.services.PizzaService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PizzaServiceTest(
    private val pizzaService: PizzaService,
    private val pizzaRepository: PizzaRepository
) {

    @Test
    fun getAllPizzaTest(){

         val pizza = Pizza(
             id = 1L,
             crust = Crust(1L, CrustType.THIN.name, CrustSize.LARGE.name),
             price = 12.0,
             toppings = listOf(Topping(1L, ToppingsName.ONIONS.name)),
             name = "Only Onion"
         )
        pizzaRepository.save(pizza)

        val allPizza = pizzaService.findAllPizzaOnMenu()

        allPizza.size

    }


}
