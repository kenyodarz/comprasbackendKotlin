package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Cotizaciones
import com.cdmservicios.comprasbackend.repositories.CotizacionesRepository
import com.cdmservicios.comprasbackend.services.apis.CotizacionesServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CotizacionesServiceImpl(repository: CotizacionesRepository) : GenericServiceImpl<Cotizaciones, Int>(),
    CotizacionesServiceAPI {
    private var repository: CotizacionesRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<Cotizaciones, Int> {
        return this.repository!!
    }
}