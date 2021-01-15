package com.cdmservicios.comprasbackend.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "facturas")
class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idfactura: Int? = null

    @JsonIgnore
    var archivo: ByteArray? = null

    @Column
    var formato: String? = null

    @Column
    var nombrearchivo: String? = null

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    var fechaderegistro: Date? = null

    @NotNull
    @OneToOne
    @JoinColumn(name = "idordendecompra")
    var ordenDeCompra: OrdenDeCompra? = null

    @OneToOne
    @JoinColumn(name = "idrecepciondepedido")
    var recepcionDePedidos: RecepcionDePedidos? = null


    fun getArchivoHashCode(): Int? {
        return if (archivo != null) Arrays.hashCode(archivo) else null
    }

    @PrePersist
    fun prePersist() {
        fechaderegistro = Date()
    }

}