package org.example.Controller

import org.example.NodeEntity.Pizza
import org.example.services.PizzaService

@RestController
@RequestMapping("/menu")
class PizzaController() {

    @Autowired
    private lateinit var pizzaService: PizzaService

    @GetMapping()
    fun getMenu(): List<Pizza>? {
        return pizzaService.getAllPizzas()
    }

    @GetMapping("/{id}")
    fun getMenuItem(@PathVariable id: Long): Pizza? {
        return pizzaService.getPizzaById(id)
    }
}