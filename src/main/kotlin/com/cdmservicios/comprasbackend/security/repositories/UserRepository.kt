package com.cdmservicios.comprasbackend.security.repositories

import com.cdmservicios.comprasbackend.security.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByUsuario(username: String): Optional<User>

    fun existsByUsuario(username: String): Boolean

    fun existsByEmail(email: String): Boolean
}