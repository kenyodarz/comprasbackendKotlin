package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Requisition
import com.cdmservicios.comprasbackend.services.apis.RequisitionServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/requisitions")
@Api(tags = ["requisitions"])
class RequisitionRestController(override var serviceAPI: RequisitionServiceAPI) :
    GenericRestController<Requisition, Int>(serviceAPI) {

    override val all: List<Requisition>
        get() = serviceAPI.findAllRequisition()
}