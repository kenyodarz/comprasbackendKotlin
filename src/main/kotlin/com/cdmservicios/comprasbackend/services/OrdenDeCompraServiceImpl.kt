package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.OrdenDeCompra
import com.cdmservicios.comprasbackend.models.Pedido
import com.cdmservicios.comprasbackend.repositories.OrdenDeCompraRepository
import com.cdmservicios.comprasbackend.services.apis.OrdenDeCompraServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.validation.constraints.NotNull

@Service
class OrdenDeCompraServiceImpl(repository: OrdenDeCompraRepository) : GenericServiceImpl<OrdenDeCompra, Int>(),
    OrdenDeCompraServiceAPI {

    private var repository: OrdenDeCompraRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun findOrdenDeCompraByRequisition(idRequisition: Int): Iterable<Long> {
        return this.repository!!.findOrdenDeCompraByRequisition(idRequisition)
    }

    @NotNull
    @Transactional
    override fun findPedidosByOrdenDeCompraAndProducto(idRequisition: Int): List<Pedido> {
        return this.repository!!.findPedidosByOrdenDeCompraAndProducto(idRequisition)
    }

    @NotNull
    @Transactional
    override fun findOrdenDeCompraGroupByProveedor(): List<OrdenDeCompra> {
        return this.repository!!.findOrdenDeCompraGroupByProveedor()
    }

    @NotNull
    @Transactional
    override fun getRepository(): JpaRepository<OrdenDeCompra, Int> {
        return this.repository!!
    }


}