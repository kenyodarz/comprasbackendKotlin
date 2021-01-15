package com.cdmservicios.comprasbackend.models

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "pedidos")
class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idpedido: Int? = null

    @OneToOne
    @JoinColumn(name = "idrequisicion")
    var requisition: Requisition? = null

    @OneToOne
    @JoinColumn(name = "idproducto")
    var producto: Producto? = null

    @Column
    var cantidadsolicitada: Double? = null

    @Column
    var precioinicial: Double? = null

    @Column
    var destino: String? = null

    @Column
    var observaciones: String? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    var fechaderegistro: Date? = null

    @OneToOne
    @JoinColumn(name = "idordendecompra")
    var ordenDeCompra: OrdenDeCompra? = null

    var total: Double? = null
        get() = cantidadsolicitada!! * precioinicial!!

    @PrePersist
    fun prePersis() {
        fechaderegistro = Date()
    }
}