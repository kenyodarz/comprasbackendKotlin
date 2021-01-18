package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Pedido
import com.cdmservicios.comprasbackend.repositories.PedidoRepository
import com.cdmservicios.comprasbackend.services.apis.PedidoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.validation.constraints.NotNull

@Repository
class PedidoServiceImpl(repository: PedidoRepository) : GenericServiceImpl<Pedido, Int>(), PedidoServiceAPI {

    private var repository: PedidoRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<Pedido, Int> {
        return this.repository!!
    }

    @NotNull
    @Transactional
    override fun findPedidosByRequisition(id: Int): Iterable<Long> {
        return this.repository!!.findPedidosByRequisition(id)
    }

    @NotNull
    @Transactional
    override fun findPedidosByOrdenDeCompra(id: Int): List<Pedido> {
        return this.findPedidosByOrdenDeCompra(id)
    }

    @NotNull
    @Transactional
    override fun findPedidosPorOrden(idOrden: Int): Int {
        return this.findPedidosPorOrden(idOrden)
    }

    @NotNull
    @Transactional
    override fun findPedidosByRequisitionAndOrOrdenDeCompraNull(id: Int): Iterable<Long> {
        return this.findPedidosByRequisitionAndOrOrdenDeCompraNull(id)
    }
}