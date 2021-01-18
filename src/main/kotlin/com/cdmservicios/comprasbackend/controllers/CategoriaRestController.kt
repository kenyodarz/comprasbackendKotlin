package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Categoria
import com.cdmservicios.comprasbackend.services.apis.CategoriaServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/categorias")
@Api(tags = ["categorias"])
class CategoriaRestController(serviceAPI: CategoriaServiceAPI) :
    GenericRestController<Categoria, Long>(serviceAPI)