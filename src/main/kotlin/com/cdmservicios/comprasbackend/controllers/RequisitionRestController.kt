package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Requisition
import com.cdmservicios.comprasbackend.services.apis.RequisitionServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*", "https://cdm-fs.com"], maxAge = 3600)
@RestController
@RequestMapping("/api/requisitions")
@Tag(name = "requisitions")
class RequisitionRestController(override var serviceAPI: RequisitionServiceAPI) :
    GenericRestController<Requisition, Int>(serviceAPI) {

    private val logger: Logger = LoggerFactory.getLogger(RequisitionRestController::class.java)

    override fun save(entity: Requisition, result: BindingResult): ResponseEntity<*> {
        logger.info("Entity -> {}", entity.toString())
        return super.save(entity, result)
    }

    override val all: List<Requisition>
        get() = serviceAPI.findAllRequisition()
}