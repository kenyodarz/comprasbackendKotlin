package com.cdmservicios.comprasbackend.models

import com.cdmservicios.comprasbackend.security.models.User
import javax.persistence.*

@Entity
@Table(name = "centrodecostos")
class CentroDeCostos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idcentrodecostos: Long? = null

    @Column
    var centrodecostos: String? = null

    @Column
    var cliente: String? = null

    @OneToOne
    @JoinColumn(name = "idusuario")
    var usuario: User? = null

    @OneToOne
    @JoinColumn(name = "idcliente")
    var clienteT: Cliente? = null
}