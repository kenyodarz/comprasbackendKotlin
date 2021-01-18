package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Cliente
import com.cdmservicios.comprasbackend.repositories.ClienteRepository
import com.cdmservicios.comprasbackend.services.apis.ClienteServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class ClienteServiceImpl(repository: ClienteRepository) : GenericServiceImpl<Cliente, Long>(), ClienteServiceAPI {

    private var repository: ClienteRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<Cliente, Long> {
        return this.repository!!
    }
}