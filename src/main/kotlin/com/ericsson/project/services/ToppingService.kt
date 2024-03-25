package com.ericsson.project.services

import com.ericsson.project.NodeEntity.Topping
import com.ericsson.project.enums.ToppingsName
import com.ericsson.project.repository.ToppingRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ToppingService(private val toppingRepository: ToppingRepository) {

    fun findToppingByName(toppingName: ToppingsName): Topping {
        return toppingRepository.findByName(toppingName.name)?.first()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid topping: $toppingName.")
    }
}