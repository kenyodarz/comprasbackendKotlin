package com.cdmservicios.comprasbackend.models

import com.cdmservicios.comprasbackend.security.models.User
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "producto")
class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idproducto: Int? = null

    @Column
    val codigoproducto: String? = null

    @Column
    val nombreproducto: String? = null

    @Column
    val medida: String? = null

    @JsonIgnore
    var imagen: ByteArray? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var fechaderegistro: Date? = null

    @OneToOne
    @JoinColumn(name = "idusuario")
    val usuario: User? = null

    @OneToOne
    @JoinColumn(name = "idcategoria")
    val categoria: Categoria? = null


    fun getImagenHashCode(): Int? {
        return if (imagen != null) Arrays.hashCode(imagen) else null
    }

    @PrePersist
    fun prePersis() {
        fechaderegistro = Date()
    }

}