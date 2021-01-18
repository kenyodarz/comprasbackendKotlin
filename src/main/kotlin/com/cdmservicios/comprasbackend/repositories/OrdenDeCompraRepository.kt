package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.OrdenDeCompra
import com.cdmservicios.comprasbackend.models.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface OrdenDeCompraRepository : JpaRepository<OrdenDeCompra, Int> {

    @Query(
        "select  o from  OrdenDeCompra o join o.requisition r " +
                "where r.idrequisicion =?1 group by o.idordendecompra"
    )
    fun findOrdenDeCompraByRequisition(idRequisition: Int): Iterable<Long>

    @Query(
        "select ped from Pedido ped join ped.producto p " +
                "where ped.ordenDeCompra.idordendecompra =?1 ORDER BY p.nombreproducto"
    )
    fun findPedidosByOrdenDeCompraAndProducto(id: Int): List<Pedido>


    @Query(
        "select oc.idordendecompra, oc.numerodeorden, oc.fechadeorden, oc.condestinoa, oc.contacto, oc.concargoa, oc.transportador, oc.numerodeguia, oc.formadepago, oc.idusuario, oc.observaciones, oc.idrequisicion, oc.fechaderegistro, oc.fechadeactualizado, oc.iva, oc.exentodeiva, oc.centrodecostos, oc.valoriva, oc.anulada, pv.*, sum(ped.cantidadsolicitada) as totalesOCO, sum(r.recibidos) as recibidosOCO from ordendecompra oc inner join proveedor pv on (pv.idproveedor = oc.idproveedor) left join pedidos ped on ped.idordendecompra=oc.idordendecompra left join ( select rp.idpedido, sum(rp.cantidadrecibida) as recibidos from recepciondepedidos rp group by rp.idpedido order by 1) as r on r.idpedido = ped.idpedido group by oc.idordendecompra, pv.idproveedor, oc.numerodeorden order by oc.numerodeorden desc",
        nativeQuery = true
    )
    fun findOrdenDeCompraGroupByProveedor(): List<OrdenDeCompra>

}