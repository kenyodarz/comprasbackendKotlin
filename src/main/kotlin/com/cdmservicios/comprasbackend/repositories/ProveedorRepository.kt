package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Proveedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProveedorRepository : JpaRepository<Proveedor, Int>