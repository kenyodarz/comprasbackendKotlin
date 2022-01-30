package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Producto
import com.cdmservicios.comprasbackend.services.apis.ProductoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*", "https://cdm-fs.com"], maxAge = 3600)
@RestController
@RequestMapping("/api/productos")
@Tag( name = "productos")
class ProductoRestController(override var serviceAPI: ProductoServiceAPI) :
    GenericRestController<Producto, Int>(serviceAPI) {

    private val logger: Logger = LoggerFactory.getLogger(RequisitionRestController::class.java)
    override fun save(entity: Producto, result: BindingResult): ResponseEntity<*> {
        logger.info("Entity -> {}", entity.toString())
        return super.save(entity, result)
    }

    @GetMapping("image/{id}")
    fun verImagen(@PathVariable id: Int): ResponseEntity<*> {
        if (serviceAPI.getOne(id).imagen == null) return ResponseEntity.notFound()
            .build<Any>()
        val imagen: Resource = ByteArrayResource(serviceAPI.getOne(id).imagen!!)
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body<Any>(imagen)
    }

}