package com.cdmservicios.comprasbackend.models

import com.cdmservicios.comprasbackend.security.models.User
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "recepciondepedidos")
class RecepcionDePedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idrecepciondepedido: Int? = null

    @OneToOne
    @JoinColumn(name = "idpedido")
    var pedido: Pedido? = null

    @Column
    var fechaderecibido: LocalDate? = null

    @Column
    var cantidadrecibida: Double? = null

    @Column
    var preciofinal: Double? = null

    @Column
    var factura: String? = null

    @Column
    var remision: String? = null

    @Column
    var observaciones: String? = null

    @OneToOne
    @JoinColumn(name = "idusuario")
    var usuario: User? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private var fechaderegistro: Date? = null

    @PrePersist
    fun prePersist() {
        fechaderegistro = Date()
    }

}