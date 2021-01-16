package com.cdmservicios.comprasbackend.services.apis

import com.cdmservicios.comprasbackend.models.OrdenDeCompra
import com.cdmservicios.comprasbackend.models.Pedido
import com.cdmservicios.comprasbackend.shared.GenericServiceAPI

interface OrdenDeCompraServiceAPI: GenericServiceAPI<OrdenDeCompra, Int> {
    fun findOrdenDeCompraByRequisition(idRequisition: Int): Iterable<Long>
    fun findPedidosByOrdenDeCompraAndProducto(idRequisition: Int): List<Pedido>
    fun findOrdenDeCompraGroupByProveedor(): List<Any>
}