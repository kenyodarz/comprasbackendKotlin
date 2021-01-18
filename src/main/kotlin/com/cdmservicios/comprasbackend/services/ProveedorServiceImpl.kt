package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Proveedor
import com.cdmservicios.comprasbackend.repositories.ProveedorRepository
import com.cdmservicios.comprasbackend.services.apis.ProveedorServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class ProveedorServiceImpl(repository: ProveedorRepository) : GenericServiceImpl<Proveedor, Int>(), ProveedorServiceAPI {

    private var repository: ProveedorRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<Proveedor, Int> {
        return this.repository!!
    }

}