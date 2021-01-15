package com.cdmservicios.comprasbackend.security.models

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(
    name = "usuario",
    uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("usuario", "email"))]
)
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idusuario: Long? = null

    @NotBlank
    @Size(max = 20)
    var usuario: String? = null

    @NotBlank
    var nombreusuario: String? = null

    @NotBlank
    @Size(max = 100)
    @Email
    var email: String? = null

    @NotBlank
    @Size(max = 120)
    var password: String? = null

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuario_roles",
        joinColumns = [JoinColumn(name = "idusuario")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )

    var roles: Set<Role> = HashSet()


    constructor()
    constructor(usuario: String, nombreusuario: String, email: String, password: String) {
        this.usuario = usuario
        this.nombreusuario = nombreusuario
        this.email = email
        this.password = password
    }


}