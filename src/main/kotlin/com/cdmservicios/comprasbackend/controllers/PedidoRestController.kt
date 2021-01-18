package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Pedido
import com.cdmservicios.comprasbackend.services.apis.PedidoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/pedidos")
@Api(tags = ["pedidos"])
class PedidoRestController(override var serviceAPI: PedidoServiceAPI) : GenericRestController<Pedido, Int>(serviceAPI) {

    @GetMapping("/sinOrden/{id}")
    fun findPedidosByRequisitionAndOrOrdenDeCompraNull(@PathVariable id: Int): ResponseEntity<*> {
        return ResponseEntity.ok(
            serviceAPI.findPedidosByRequisitionAndOrOrdenDeCompraNull(
                id
            )
        )
    }

    @GetMapping("/orden/{id}")
    fun findPedidosByOrdenDeCompra(@PathVariable id: Int): ResponseEntity<*> {
        return ResponseEntity.ok(serviceAPI.findPedidosByOrdenDeCompra(id))
    }

    @GetMapping("/solicitados/{id}")
    fun findPedidosPorOrden(@PathVariable id: Int): ResponseEntity<*> {
        return ResponseEntity.ok(serviceAPI.findPedidosPorOrden(id))
    }

}