package com.cdmservicios.comprasbackend.models

import com.cdmservicios.comprasbackend.security.models.User
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "proveedor")
class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idproveedor: Int? = null

    @Column
    private val nombreprovee: String? = null

    @Column
    private val nitprovee: String? = null

    @Column
    private val direccionprovee: String? = null

    @Column
    private val telefonofijoprovee: String? = null

    @Column
    private val celularprovee: String? = null

    @Column
    private val correoprovee: String? = null

    @Column
    private val paginawebprovee: String? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private val fechaderegistro: Date? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private val fechaactualizado: Date? = null

    @OneToOne
    @JoinColumn(name = "idusuario")
    private val usuario: User? = null

    @Column
    private val ciudad: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "producto_proveedor",
        joinColumns = [JoinColumn(name = "idproveedor")],
        inverseJoinColumns = [JoinColumn(name = "idproducto")]
    )
    private val productos: List<Producto>? = null

}