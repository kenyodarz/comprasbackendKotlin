package com.cdmservicios.comprasbackend.shared

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import java.io.Serializable
import java.util.function.Consumer
import javax.validation.Valid


@RestController
abstract class GenericRestController<T, ID : Serializable>(val serviceAPI: GenericServiceAPI<T, ID>) {


    fun validar(result: BindingResult): ResponseEntity<*> {
        val errores: MutableMap<String, Any> = HashMap()
        result.fieldErrors.forEach(Consumer { err: FieldError ->
            errores[err.field] = " El campo " + err.field + " " + err.defaultMessage
        })
        return ResponseEntity.badRequest().body<Map<String, Any>>(errores)
    }

    @get:PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @get:ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Entidades Listadas Correctamente"
        ), ApiResponse(responseCode = "401", description = "Usuario No Autorizado"), ApiResponse(
            responseCode = "403",
            description = "Solicitud prohibida por el servidor"
        ), ApiResponse(responseCode = "404", description = "Entidad no encontrada")]
    )
    @get:Operation(
        method = "Listar Entidades",
        description = "servicio para listar todas las Entidades"
    )
    @get:GetMapping("/all")
    val all: List<T>
        get() = serviceAPI.getAll()

    @GetMapping("/{id}")
    @Operation(method = "Obtener una Entidad", description = "servicio para obtener una Entidad")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Entidad encontrada correctamente"
        ), ApiResponse(responseCode = "401", description = "Usuario No Autorizado"), ApiResponse(
            responseCode = "403",
            description = "Solicitud prohibida por el servidor"
        ), ApiResponse(responseCode = "404", description = "Entidad no encontrada")]
    )
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    fun find(@PathVariable id: ID): ResponseEntity<*> {
        val entity: T = serviceAPI.getOne(id) ?: return ResponseEntity.notFound().build<Any>()
        return ResponseEntity.ok(entity!!)
    }

    @PostMapping("/save")
    @Operation(method = "Crear/Editar una Entidad", description = "servicio para crear o editar entidades")
    @ApiResponses(
        value = [ApiResponse(responseCode = "200", description = "Entidad creada correctamente"), ApiResponse(
            responseCode = "401",
            description = "Usuario No Autorizado"
        ), ApiResponse(responseCode = "403", description = "Solicitud prohibida por el servidor"), ApiResponse(
            responseCode = "404",
            description = "Entidad no encontrada"
        )]
    )
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    fun save(@RequestBody entity: @Valid T, result: BindingResult): ResponseEntity<*> {
        return if (result.hasErrors()) {
            validar(result)
        } else ResponseEntity.status(HttpStatus.OK).body(serviceAPI.save(entity))
    }

    @GetMapping("/delete/{id}")
    @Operation(method = "Eliminar una Entidad", description = "servicio para eliminar entidades")
    @ApiResponses(
        value = [ApiResponse(responseCode = "200", description = "Entidad eliminada correctamente"), ApiResponse(
            responseCode = "401",
            description = "Usuario No Autorizado"
        ), ApiResponse(responseCode = "403", description = "Solicitud prohibida por el servidor"), ApiResponse(
            responseCode = "404",
            description = "Entidad no encontrada"
        )]
    )
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    fun delete(@PathVariable id: ID): ResponseEntity<*> {
        val entity: T = serviceAPI.getOne(id)!!
        if (entity != null) {
            serviceAPI.delete(id)
        } else {
            return ResponseEntity<Any>(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity<T>(entity, HttpStatus.OK)
    }
}
