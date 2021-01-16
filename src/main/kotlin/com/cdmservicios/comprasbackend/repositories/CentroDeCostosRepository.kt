package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.CentroDeCostos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CentroDeCostosRepository : JpaRepository<CentroDeCostos, Long>