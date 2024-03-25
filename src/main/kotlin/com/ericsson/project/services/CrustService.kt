package com.ericsson.project.services


import com.ericsson.project.NodeEntity.Crust
import com.ericsson.project.repository.CrustRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CrustService(
    private val crustRepository: CrustRepository
) {
    fun getCrustByTypeAndSize(crustType: String, crustSize: String): Crust? {
        return crustRepository.findByTypeAndSize(
            crustType,
            crustSize
        )?.first()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid crust size or type.")
    }
}