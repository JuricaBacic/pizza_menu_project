package com.ericsson.project.services

import com.ericsson.project.repository.ToppingRepository
import org.springframework.stereotype.Service

@Service
class ToppingService(private val toppingRepository: ToppingRepository) {}