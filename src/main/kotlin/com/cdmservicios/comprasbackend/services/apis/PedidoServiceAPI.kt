package com.cdmservicios.comprasbackend.services.apis

import com.cdmservicios.comprasbackend.models.Pedido
import com.cdmservicios.comprasbackend.shared.GenericServiceAPI


interface PedidoServiceAPI : GenericServiceAPI<Pedido, Int> {
    fun findPedidosByRequisition(id: Int): Iterable<Long>
    fun findPedidosByOrdenDeCompra(id: Int): List<Pedido>
    fun findPedidosPorOrden(idOrden: Int): Int
    fun findPedidosByRequisitionAndOrOrdenDeCompraNull(id: Int): Iterable<Long>
}