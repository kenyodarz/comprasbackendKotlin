package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Requisition
import com.cdmservicios.comprasbackend.repositories.RequisitionRepository
import com.cdmservicios.comprasbackend.services.apis.RequisitionServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class RequisitionServiceImpl(repository: RequisitionRepository) : GenericServiceImpl<Requisition, Int>(),
    RequisitionServiceAPI {

    private var repository: RequisitionRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<Requisition, Int> {
        return this.repository!!
    }
}