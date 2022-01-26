package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Factura
import com.cdmservicios.comprasbackend.services.apis.FacturaServiceAPI
import com.cdmservicios.comprasbackend.services.apis.OrdenDeCompraServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import javax.validation.Valid


@CrossOrigin(origins = ["*", "https://cdm-fs.com"], maxAge = 3600)
@RestController
@RequestMapping("/api/facturas")
@Tag(name = "facturas")
class FacturasRestController(
    override var serviceAPI: FacturaServiceAPI,
    var ordenServiceAPI: OrdenDeCompraServiceAPI
) : GenericRestController<Factura, Int>(serviceAPI) {

    @GetMapping("/orden/{idOrden}")
    fun findFacturasByOrdenDeCompra(@PathVariable idOrden: Int): ResponseEntity<*> {
        return ResponseEntity.ok(serviceAPI.findFacturasByOrdenDeCompra(idOrden))
    }

    @GetMapping("/archivo/{id}")
    fun verArchivo(@PathVariable id: Int): ResponseEntity<*> {
        val entity: Factura = serviceAPI.getOne(id)
        if (entity.archivo == null) return ResponseEntity.notFound().build<Any>()
        val resource: Resource = ByteArrayResource(entity.archivo!!)
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body<Any>(resource)
    }

    @PostMapping("/save-file/{id}")
    @Throws(IOException::class)
    fun guardarFactura(
        entity: @Valid Factura, result: BindingResult,
        @RequestParam archivo: MultipartFile,
        @PathVariable id: Int
    ): ResponseEntity<*> {
        if (!archivo.isEmpty) {
            entity.archivo = archivo.bytes
            entity.ordenDeCompra = ordenServiceAPI.getOne(id)
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAPI.save(entity))
    }
}