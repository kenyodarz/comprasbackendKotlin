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
    private var idrequisicion: Int? = null

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private var numerorequisicion: Int? = null

    @Column
    private var referencia: String? = null

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private var fechaderegistro: Date? = null

    @OneToOne
    @JoinColumn(name = "idusuario")
    private var usuario: User? = null

    @OneToOne
    @JoinColumn(name = "idcentrodecostos")
    private var centroDeCostos: CentroDeCostos? = null

    @Column
    private var observaciones: String? = null

    @PrePersist
    fun prePersist() {
        fechaderegistro = Date()
    }

    fun getIdrequisicion(): Int? {
        return idrequisicion
    }

    fun setIdrequisicion(idrequisicion: Int?) {
        idrequisicion.also { this.idrequisicion = it }
    }
}