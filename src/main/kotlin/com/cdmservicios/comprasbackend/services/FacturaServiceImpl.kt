package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Factura
import com.cdmservicios.comprasbackend.repositories.FacturaRepository
import com.cdmservicios.comprasbackend.services.apis.FacturaServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.validation.constraints.NotNull

@Service
class FacturaServiceImpl(repository: FacturaRepository) : GenericServiceImpl<Factura, Int>(), FacturaServiceAPI {

    private var repository: FacturaRepository? = null

    init {
        repository.also { this.repository = it }
    }

    @NotNull
    @Transactional
    override fun findFacturasByOrdenDeCompra(idOrden: Int): List<Factura> {
        return this.repository!!.findFacturasByByAndOrdenDeCompra(idOrden)
    }

    override fun getRepository(): JpaRepository<Factura, Int> {
        return this.repository!!
    }
}