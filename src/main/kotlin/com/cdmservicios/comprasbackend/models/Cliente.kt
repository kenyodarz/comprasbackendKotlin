package com.cdmservicios.comprasbackend.models

import javax.persistence.*

@Entity
@Table(name = "cliente")
class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idcliente: Long? = null

    @Column
    var nombrecliente: String? = null
}