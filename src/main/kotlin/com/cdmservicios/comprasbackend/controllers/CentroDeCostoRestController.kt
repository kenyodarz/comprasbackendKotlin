package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.CentroDeCostos
import com.cdmservicios.comprasbackend.services.apis.CentroDeCostoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*", "https://cdm-fs.com"], maxAge = 3600)
@RestController
@RequestMapping("/api/centros")
@Tag(name = "centros")
class CentroDeCostoRestController(serviceAPI: CentroDeCostoServiceAPI) :
    GenericRestController<CentroDeCostos, Long>(serviceAPI)