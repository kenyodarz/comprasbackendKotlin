package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Cotizaciones
import com.cdmservicios.comprasbackend.services.apis.CotizacionesServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/cotizaciones")
@Tag(name = "cotizaciones")
class CotizacionesRestController(override var serviceAPI: CotizacionesServiceAPI) :
    GenericRestController<Cotizaciones, Int>(serviceAPI) {

    @GetMapping("/archivo/{id}") //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    fun verArchivo(@PathVariable id: Int): ResponseEntity<*>? {
        val entity: Cotizaciones = serviceAPI.getOne(id)
        if (entity.archivo == null) return ResponseEntity.notFound().build<Any>()
        val resource: Resource = ByteArrayResource(entity.archivo!!)
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body<Any>(resource)
    }

}