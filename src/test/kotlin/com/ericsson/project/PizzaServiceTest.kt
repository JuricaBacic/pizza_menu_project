package com.ericsson.project

import com.ericsson.project.NodeEntity.Crust
import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.NodeEntity.Topping
import com.ericsson.project.repository.PizzaRepository
import com.ericsson.project.services.PizzaService
import io.kotest.matchers.shouldBe
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PizzaServiceTest {

    @Autowired private lateinit var pizzaService: PizzaService
    @Autowired private lateinit var pizzaRepository: PizzaRepository

    @Test
    fun `find all pizza`() {
        val pizzas = listOf(
            Pizza(
                id = 1L,
                name = "Only Onion",
                price = 12.0,
                crust = Crust(1L, CrustType.THIN.name, CrustSize.LARGE.name),
                toppings = listOf(Topping(1L, ToppingsName.ONIONS.name))
            ),
            Pizza(
                id = 2L,
                name = "Peppy Cheese",
                price = 15.0,
                crust = Crust(2L, CrustType.CHEESE_FILLED.name, CrustSize.SMALL.name),
                toppings = listOf(Topping(2L, ToppingsName.PEPPERONI.name), Topping(3L, ToppingsName.MOZZARELLA.name))
            ),
            Pizza(
                id = 3L,
                name = "Mushroom Olive",
                price = 18.0,
                crust = Crust(3L, CrustType.THICK.name, CrustSize.MEDIUM.name),
                toppings = listOf(Topping(4L, ToppingsName.MUSHROOMS.name), Topping(5L, ToppingsName.BLACK_OLIVES.name))
            ),
            Pizza(
                id = 4L,
                name = "Green Pepper Deluxe",
                price = 20.0,
                crust = Crust(4L, CrustType.GLUTEN_FREE.name, CrustSize.LARGE.name),
                toppings = listOf(
                    Topping(6L, ToppingsName.GREEN_PEPPERS.name),
                    Topping(7L, ToppingsName.EXTRA_CHEESE.name)
                )
            ),
            Pizza(
                id = 5L,
                name = "Classic Pepperoni",
                price = 14.0,
                crust = Crust(5L, CrustType.THIN.name, CrustSize.MEDIUM.name),
                toppings = listOf(
                    Topping(8L, ToppingsName.TOMATO_SAUCE.name),
                    Topping(9L, ToppingsName.MOZZARELLA.name),
                    Topping(10L, ToppingsName.PEPPERONI.name)
                )
            )
        )

        pizzas.forEach { pizza ->
            pizzaRepository.save(pizza)
        }

        val allPizza = pizzaService.findAllPizzaOnMenu()
        allPizza.size shouldBe 5
    }

    @Test
    fun `find pizza by pizza id`() {
        val pizzas = listOf(
            Pizza(
                id = 1L,
                name = "Only Onion",
                price = 12.0,
                crust = Crust(1L, CrustType.THIN.name, CrustSize.LARGE.name),
                toppings = listOf(Topping(1L, ToppingsName.ONIONS.name))
            ),
            Pizza(
                id = 2L,
                name = "Peppy Cheese",
                price = 15.0,
                crust = Crust(2L, CrustType.CHEESE_FILLED.name, CrustSize.SMALL.name),
                toppings = listOf(Topping(2L, ToppingsName.PEPPERONI.name), Topping(3L, ToppingsName.MOZZARELLA.name))
            ),
            Pizza(
                id = 3L,
                name = "Mushroom Olive",
                price = 18.0,
                crust = Crust(3L, CrustType.THICK.name, CrustSize.MEDIUM.name),
                toppings = listOf(Topping(4L, ToppingsName.MUSHROOMS.name), Topping(5L, ToppingsName.BLACK_OLIVES.name))
            ),
            Pizza(
                id = 4L,
                name = "Green Pepper Deluxe",
                price = 20.0,
                crust = Crust(4L, CrustType.GLUTEN_FREE.name, CrustSize.LARGE.name),
                toppings = listOf(
                    Topping(6L, ToppingsName.GREEN_PEPPERS.name),
                    Topping(7L, ToppingsName.EXTRA_CHEESE.name)
                )
            ),
            Pizza(
                id = 5L,
                name = "Classic Pepperoni",
                price = 14.0,
                crust = Crust(5L, CrustType.THIN.name, CrustSize.MEDIUM.name),
                toppings = listOf(
                    Topping(8L, ToppingsName.TOMATO_SAUCE.name),
                    Topping(9L, ToppingsName.MOZZARELLA.name),
                    Topping(10L, ToppingsName.PEPPERONI.name)
                )
            )
        )
        pizzas.forEach { pizza ->
            pizzaRepository.save(pizza)
        }

        val specificPizza = pizzaService.getPizzaById(2L)
        specificPizza.id shouldBe 2L
        specificPizza.name shouldBe "Peppy Cheese"
        specificPizza.crust shouldBe Crust(2L, CrustType.CHEESE_FILLED.name, CrustSize.SMALL.name)
        specificPizza.toppings shouldBe listOf(Topping(2L, ToppingsName.PEPPERONI.name), Topping(3L, ToppingsName.MOZZARELLA.name))
    }
}