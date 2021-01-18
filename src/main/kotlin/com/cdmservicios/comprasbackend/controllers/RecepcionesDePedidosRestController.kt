package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.RecepcionDePedidos
import com.cdmservicios.comprasbackend.services.apis.RecepcionDePedidosServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/recepciones")
@Api(tags = ["recepciones"])
class RecepcionesDePedidosRestController(override var serviceAPI: RecepcionDePedidosServiceAPI) :
    GenericRestController<RecepcionDePedidos, Int>(serviceAPI) {

    @GetMapping("/porPedido/{id}")
    fun findRecepcionesDePedidosByPedido(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok(serviceAPI.findRecepcionesDePedidosByPedido(id))
    }

    @GetMapping("/recibidos/{id}")
    fun findRecepcionesPorPedidos(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok(serviceAPI.findRecepcionesPorPedidos(id))
    }
}