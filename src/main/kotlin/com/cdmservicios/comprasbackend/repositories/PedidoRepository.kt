package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface PedidoRepository : JpaRepository<Repository, Int> {


    @Query(
        "select p.idpedido from Pedido p join p.requisition r " +
                "where r.idrequisicion =?1 group by p.idpedido"
    )
    fun findPedidosByRequisition(id: Int): Iterable<Long>

    @Query(
        "select p from Pedido p join p.ordenDeCompra o where o.idordendecompra = ?1 group by p.idpedido"
    )
    fun findAllPedidosByOrdenDeCompra(id: Int): List<Pedido>

    @Query(
        "select p.idpedido from Pedido p join p.requisition r " +
                "where r.idrequisicion =?1 and p.ordenDeCompra is null group by p.idpedido"
    )
    fun findPedidosByRequisitionAndOrOrdenDeCompraNull(id: Int): Iterable<Long>

    @Query(
        "select sum(p.cantidadsolicitada) as solicitados from Pedido p " +
                "where p.ordenDeCompra.idordendecompra=?1"
    )
    fun PedidosPorOrden(idOrden: Int): Int


}