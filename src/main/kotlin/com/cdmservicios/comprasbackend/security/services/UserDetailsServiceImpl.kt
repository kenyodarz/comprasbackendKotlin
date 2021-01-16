package com.cdmservicios.comprasbackend.security.services

import com.cdmservicios.comprasbackend.security.models.User
import com.cdmservicios.comprasbackend.security.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDetailsServiceImpl: UserDetailsService{

    @Autowired
    val repository: UserRepository? = null

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val user: User = repository!!.findByUsuario(username)
                .orElseThrow { UsernameNotFoundException("No se ha encontrado el usuario: $username") }
        return UserDetailsImpl.build(user)
    }
}