package com.cdmservicios.comprasbackend.models

import com.cdmservicios.comprasbackend.security.models.User
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "requisicion")
class Requisition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idrequisicion: Int? = null

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    var numerorequisicion: Int? = null

    @Column
    var referencia: String? = null

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    var fechaderegistro: Date? = null

    @OneToOne
    @JoinColumn(name = "idusuario")
    var usuario: User? = null

    @OneToOne
    @JoinColumn(name = "idcentrodecostos")
    var centroDeCostos: CentroDeCostos? = null

    @Column
    var observaciones: String? = null

    @PrePersist
    fun prePersist() {
        fechaderegistro = Date()
    }
}