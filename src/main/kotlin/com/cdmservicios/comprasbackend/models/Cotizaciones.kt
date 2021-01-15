package com.cdmservicios.comprasbackend.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "cotizaciones")
class Cotizaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idcotizacion: Int? = null

    @Column
    var formato: String? = null

    @Column
    var nombrearchivo: String? = null

    @Column
    var fechaderegistro: LocalDateTime? = null

    @OneToOne
    @JoinColumn(name = "idrequisicion")
    var requisition: Requisition? = null

    //@Lob()
    @JsonIgnore
    var archivo: ByteArray? = null

    fun getArchivoHashCode(): Int? {
        return if (archivo != null) Arrays.hashCode(archivo) else null
    }


}