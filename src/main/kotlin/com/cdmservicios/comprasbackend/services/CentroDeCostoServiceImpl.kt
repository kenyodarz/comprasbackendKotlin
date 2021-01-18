package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.CentroDeCostos
import com.cdmservicios.comprasbackend.repositories.CentroDeCostosRepository
import com.cdmservicios.comprasbackend.services.apis.CentroDeCostoServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CentroDeCostoServiceImpl(repository: CentroDeCostosRepository) : GenericServiceImpl<CentroDeCostos, Long>(),
    CentroDeCostoServiceAPI {

    private var repository: CentroDeCostosRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<CentroDeCostos, Long> {
        return this.repository!!
    }
}