package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Requisition
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequisitionRepository : JpaRepository<Requisition, Int>