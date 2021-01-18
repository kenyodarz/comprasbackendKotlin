package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.CentroDeCostos
import com.cdmservicios.comprasbackend.services.apis.CentroDeCostoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/centros")
@Api(tags = ["centros"])
class CentroDeCostoRestController(serviceAPI: CentroDeCostoServiceAPI) :
    GenericRestController<CentroDeCostos, Long>(serviceAPI)