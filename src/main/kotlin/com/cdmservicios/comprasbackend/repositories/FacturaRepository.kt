package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Factura
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface FacturaRepository : JpaRepository<Factura, Int> {

    @Query("select f from Factura f where f.ordenDeCompra.idordendecompra =?1 order by f.idfactura")
    fun findFacturasByByAndOrdenDeCompra(idOrden: Int): List<Factura>
}