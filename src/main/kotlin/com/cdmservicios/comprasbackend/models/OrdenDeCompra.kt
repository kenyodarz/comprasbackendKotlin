package com.cdmservicios.comprasbackend.models

import com.cdmservicios.comprasbackend.security.models.User
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "ordendecompra")
class OrdenDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idordendecompra: Int? = null

    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var numerodeorden: Int? = null

    @Column
    var fechadeorden: LocalDate? = null

    @OneToOne
    @JoinColumn(name = "idproveedor")
    var proveedor: Proveedor? = null

    @Column
    var condestinoa: String? = null

    @Column
    var contacto: String? = null

    @Column
    var concargoa: String? = null

    @Column
    var transportador: String? = null

    @Column
    var numerodeguia: String? = null

    @Column
    var formadepago: String? = null

    @NotNull
    @OneToOne
    @JoinColumn(name = "idusuario")
    var usuario: User? = null

    @Column
    var observaciones: String? = null

    @OneToOne
    @JoinColumn(name = "idrequisicion")
    var requisition: Requisition? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private var fechaderegistro: Date? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private var fechadeactualizado: Date? = null

    @Column
    var iva: Int? = null

    @Column
    var exentodeiva: Boolean? = null

    @Column
    var centrodecostos: String? = null

    @Column
    var valoriva: Double? = null

    @Column
    var anulada: Boolean? = null

    @Column(insertable = false)
    var recibidosOCO: Int? = null

    @Column(insertable = false)
    var totalesOCO: Int? = null

    @PrePersist
    fun prePersis() {
        fechaderegistro = Date()
    }

    @PreUpdate
    fun preUpdate() {
        fechadeactualizado = Date()
    }

}