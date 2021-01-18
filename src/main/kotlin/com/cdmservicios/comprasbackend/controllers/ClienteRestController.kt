package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Cliente
import com.cdmservicios.comprasbackend.services.apis.ClienteServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/clientes")
@Api(tags = ["clientes"])
class ClienteRestController(serviceAPI: ClienteServiceAPI) : GenericRestController<Cliente, Long>(serviceAPI) 