package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.RecepcionDePedidos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface RecepcionDePedidosRepository : JpaRepository<RecepcionDePedidos, Int> {

    @Query(
        "select r from RecepcionDePedidos r join r.pedido p " +
                "where p.idpedido =?1 group by r.idrecepciondepedido"
    )
    fun findRecepcionesDePedidosByPedido(idPedido: Int): List<RecepcionDePedidos>

    @Query(
        "select sum(rp.cantidadrecibida) as recibidos from RecepcionDePedidos rp " +
                "where rp.pedido.ordenDeCompra.idordendecompra =?1"
    )
    fun findRecepcionesPorPedidos(idOrden: Int): Int

}