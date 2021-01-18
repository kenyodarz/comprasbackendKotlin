package com.cdmservicios.comprasbackend.services

import com.cdmservicios.comprasbackend.models.RecepcionDePedidos
import com.cdmservicios.comprasbackend.repositories.RecepcionDePedidosRepository
import com.cdmservicios.comprasbackend.services.apis.RecepcionDePedidosServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.validation.constraints.NotNull

@Service
class RecepcionDePedidosServiceImpl(repository: RecepcionDePedidosRepository) :
    GenericServiceImpl<RecepcionDePedidos, Int>(), RecepcionDePedidosServiceAPI {

    private var repository: RecepcionDePedidosRepository? = null

    init {
        repository.also { this.repository = it }
    }

    override fun getRepository(): JpaRepository<RecepcionDePedidos, Int> {
        return this.repository!!
    }

    @NotNull
    @Transactional
    override fun findRecepcionesDePedidosByPedido(idPedido: Int): List<RecepcionDePedidos> {
        return this.repository!!.findRecepcionesDePedidosByPedido(idPedido)
    }

    @NotNull
    @Transactional
    override fun findRecepcionesPorPedidos(idPedido: Int): Int {
        return this.repository!!.findRecepcionesPorPedidos(idPedido)
    }
}