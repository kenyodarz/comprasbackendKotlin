package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Producto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductoRepository : JpaRepository<Producto, Int>