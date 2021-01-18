package com.cdmservicios.comprasbackend.services.apis

import com.cdmservicios.comprasbackend.models.RecepcionDePedidos
import com.cdmservicios.comprasbackend.shared.GenericServiceAPI


interface RecepcionDePedidosServiceAPI : GenericServiceAPI<RecepcionDePedidos, Int> {
    fun findRecepcionesDePedidosByPedido(idPedido: Int): List<RecepcionDePedidos>
    fun findRecepcionesPorPedidos(idPedido: Int): Int
}