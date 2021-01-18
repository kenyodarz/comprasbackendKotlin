package com.cdmservicios.comprasbackend.models

import com.cdmservicios.comprasbackend.security.models.User
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList


@Entity
@Table(name = "proveedor")
class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idproveedor: Int? = null

    @Column
    var nombreprovee: String? = null

    @Column
    var nitprovee: String? = null

    @Column
    var direccionprovee: String? = null

    @Column
    var telefonofijoprovee: String? = null

    @Column
    var celularprovee: String? = null

    @Column
    var correoprovee: String? = null

    @Column
    var paginawebprovee: String? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var fechaderegistro: Date? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var fechaactualizado: Date? = null

    @OneToOne
    @JoinColumn(name = "idusuario")
    var usuario: User? = null

    @Column
    var ciudad: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "producto_proveedor",
        joinColumns = [JoinColumn(name = "idproveedor")],
        inverseJoinColumns = [JoinColumn(name = "idproducto")]
    )
    private var productos: MutableList<Producto>? = null


    init {
        productos = ArrayList<Producto>()
    }

    fun addProducto(producto: Producto) {
        productos!!.add(producto)
    }

    fun removeProducto(producto: Producto) {
        productos!!.remove(producto)
    }
}