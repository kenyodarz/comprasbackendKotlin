package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Producto
import com.cdmservicios.comprasbackend.services.apis.ProductoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/productos")
@Tag( name = "productos")
class ProductoRestController(override var serviceAPI: ProductoServiceAPI) :
    GenericRestController<Producto, Int>(serviceAPI) {

    @GetMapping("image/{id}")
    fun verImagen(@PathVariable id: Int): ResponseEntity<*> {
        if (serviceAPI.getOne(id).imagen == null) return ResponseEntity.notFound()
            .build<Any>()
        val imagen: Resource = ByteArrayResource(serviceAPI.getOne(id).imagen!!)
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body<Any>(imagen)
    }

}