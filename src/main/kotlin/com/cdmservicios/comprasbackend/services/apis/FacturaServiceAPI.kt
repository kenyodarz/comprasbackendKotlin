package com.cdmservicios.comprasbackend.services.apis

import com.cdmservicios.comprasbackend.models.Factura
import com.cdmservicios.comprasbackend.shared.GenericServiceAPI


interface FacturaServiceAPI : GenericServiceAPI<Factura, Int> {
    fun findFacturasByOrdenDeCompra(idOrden: Int): List<Factura>
}