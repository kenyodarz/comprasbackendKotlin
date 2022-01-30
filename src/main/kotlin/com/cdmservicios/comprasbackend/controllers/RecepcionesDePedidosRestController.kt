package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.RecepcionDePedidos
import com.cdmservicios.comprasbackend.services.apis.RecepcionDePedidosServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*", "https://cdm-fs.com"], maxAge = 3600)
@RestController
@RequestMapping("/api/recepciones")
@Tag(name = "recepciones")
class RecepcionesDePedidosRestController(override var serviceAPI: RecepcionDePedidosServiceAPI) :
    GenericRestController<RecepcionDePedidos, Int>(serviceAPI) {

    private val logger: Logger = LoggerFactory.getLogger(RequisitionRestController::class.java)


    override fun save(entity: RecepcionDePedidos, result: BindingResult): ResponseEntity<*> {
        logger.info("Entity -> {}", entity.toString())
        return super.save(entity, result)
    }

    @GetMapping("/porPedido/{id}")
    fun findRecepcionesDePedidosByPedido(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok(serviceAPI.findRecepcionesDePedidosByPedido(id))
    }

    @GetMapping("/recibidos/{id}")
    fun findRecepcionesPorPedidos(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok(serviceAPI.findRecepcionesPorPedidos(id))
    }
}