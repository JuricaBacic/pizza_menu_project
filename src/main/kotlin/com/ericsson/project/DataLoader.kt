package com.ericsson.project

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import com.ericsson.project.NodeEntity.Crust
import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.NodeEntity.Topping
import com.ericsson.project.repository.CrustRepository
import com.ericsson.project.repository.PizzaRepository
import com.ericsson.project.repository.ToppingRepository
import kotlin.random.Random

@Component
@Transactional("transactionManager")
class DataLoader(
    private val pizzaRepository: PizzaRepository,
    private val crustRepository: CrustRepository,
    private val toppingRepository: ToppingRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val crusts = initCrusts()
        val toppings = initToppings()

        (1..10).forEach { index ->
            val randomCrust = crusts.random()
            val randomToppings = toppings.shuffled().take(Random.nextInt(1, toppings.size + 1))
            val pizza = Pizza(
                name = "Pizza $index",
                price = Random.nextDouble(8.0, 20.0), // Example price range
                crust = randomCrust,
                toppings = randomToppings
            )
            pizzaRepository.save(pizza)
        }
    }

    private fun initCrusts(): List<Crust> = CrustType.values().flatMap { type ->
        CrustSize.values().map { size ->
            crustRepository.save(Crust(type = type.type, size = size.size))
        }
    }

    private fun initToppings(): List<Topping> = ToppingsName.values().map { name ->
        toppingRepository.save(Topping(name = name.type))
    }
}

enum class CrustSize(val size: String) {
    SMALL("Small"), MEDIUM("Medium"), LARGE("Large")
}

enum class CrustType(val type: String) {
    THIN("Thin"), THICK("Thick"), CHEESE_FILLED("Cheese Filled"), GLUTEN_FREE("Gluten Free")
}

enum class ToppingsName(val type: String) {
    MOZZARELLA("Mozzarella"), TOMATO_SAUCE("Tomato Sauce"), PEPPERONI("Pepperoni"),
    MUSHROOMS("Mushrooms"), ONIONS("Onions"), BLACK_OLIVES("Black Olives"),
    GREEN_PEPPERS("Green Peppers"), EXTRA_CHEESE("Extra Cheese")
}