package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Categoria

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long>
