package com.cdmservicios.comprasbackend.models

import java.util.*
import javax.persistence.*



@Entity
@Table(name = "categoria")
class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idcategoria: Long? = null

    @Column
    var nombrecategoria: String? = null

    @Column
    var descripcioncategoria: String? = null

    @Temporal(TemporalType.TIMESTAMP)
    var fechaderegistro: Date? = null

    @Column
    var idusuario: Long? = null
}