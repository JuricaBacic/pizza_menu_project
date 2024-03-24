package com.ericsson.project.Controller

import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.services.PizzaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menu")
class PizzaController() {

    @Autowired
    private lateinit var pizzaService: PizzaService

    @GetMapping()
    fun getMenu(): List<Pizza>? {
        return pizzaService.findAllPizzaOnMenu()
    }

    @GetMapping("/{uid}")
    fun getMenuItem(@PathVariable id: Long): Pizza? {
        return pizzaService.getPizzaById(id)
    }
}