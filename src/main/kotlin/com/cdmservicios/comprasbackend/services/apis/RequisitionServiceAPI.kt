package com.cdmservicios.comprasbackend.services.apis

import com.cdmservicios.comprasbackend.models.Requisition
import com.cdmservicios.comprasbackend.shared.GenericServiceAPI

interface RequisitionServiceAPI : GenericServiceAPI<Requisition, Int> {
    fun findAllRequisition(): List<Requisition>
}