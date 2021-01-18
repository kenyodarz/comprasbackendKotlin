package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.Categoria
import com.cdmservicios.comprasbackend.repositories.CategoriaRepository
import com.cdmservicios.comprasbackend.services.apis.CategoriaServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CategoriaServiceImpl(repository: CategoriaRepository) : GenericServiceImpl<Categoria, Long>(),
    CategoriaServiceAPI {
    private var repository: CategoriaRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<Categoria, Long> {
        return this.repository!!
    }
}