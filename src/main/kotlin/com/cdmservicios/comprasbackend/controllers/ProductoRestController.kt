package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Producto
import com.cdmservicios.comprasbackend.services.apis.ProductoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType

import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.GetMapping




@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/productos")
@Api(tags = ["productos"])
class ProductoRestController(override var serviceAPI: ProductoServiceAPI) :
    GenericRestController<Producto, Int>(serviceAPI) {

    @GetMapping("image/{id}")
    fun verImagen(@PathVariable id: Int): ResponseEntity<*> {
        if (serviceAPI.getOne(id) == null || serviceAPI.getOne(id).imagen == null) return ResponseEntity.notFound()
            .build<Any>()
        val imagen: Resource = ByteArrayResource(serviceAPI.getOne(id).imagen!!)
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body<Any>(imagen)
    }

    }