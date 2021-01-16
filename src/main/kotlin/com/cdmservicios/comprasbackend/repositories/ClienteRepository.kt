package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long>