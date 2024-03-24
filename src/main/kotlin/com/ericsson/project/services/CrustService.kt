package com.ericsson.project.services

import com.ericsson.project.repository.CrustRepository
import org.springframework.stereotype.Service

@Service
class CrustService(
    private val crustRepository: CrustRepository
) {
}