package com.ericsson.project.Controller

import com.ericsson.project.NodeEntity.Pizza
import com.ericsson.project.services.PizzaService
import org.example.models.PizzaOrderRequestModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/menu")
class PizzaController() {

    @Autowired
    private lateinit var pizzaService: PizzaService

    @GetMapping()
    fun getMenu(): List<Pizza>? {
        return pizzaService.findAllPizzaOnMenu()
    }

    @GetMapping("/{id}")
    fun getMenuItem(@PathVariable id: Long): Pizza? {
        return pizzaService.getPizzaById(id)
    }

    @GetMapping("/list")
    fun getMenuItems(@RequestParam("ids") ids: List<Long>): List<Pizza>? {
        return pizzaService.getAllPizzaByIds(ids)
    }

    @PostMapping
    fun placeOrder(@RequestBody pizzaRequestModel: PizzaOrderRequestModel): ResponseEntity<String> {

        pizzaService.placePizzaOrder(pizzaRequestModel)

        return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully")
    }
}