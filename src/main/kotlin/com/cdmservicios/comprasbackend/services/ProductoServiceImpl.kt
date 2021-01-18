package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Producto
import com.cdmservicios.comprasbackend.repositories.ProductoRepository
import com.cdmservicios.comprasbackend.services.apis.ProductoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class ProductoServiceImpl(repository: ProductoRepository) : GenericServiceImpl<Producto, Int>(), ProductoServiceAPI {

    private var repository: ProductoRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<Producto, Int> {
        return this.repository!!
    }
}