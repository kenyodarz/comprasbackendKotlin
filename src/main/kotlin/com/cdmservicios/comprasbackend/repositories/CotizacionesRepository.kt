package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Cotizaciones
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CotizacionesRepository : JpaRepository<Cotizaciones, Int>