package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Producto
import com.cdmservicios.comprasbackend.models.Proveedor
import com.cdmservicios.comprasbackend.services.apis.ProductoServiceAPI
import com.cdmservicios.comprasbackend.services.apis.ProveedorServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*", "https://cdm-fs.com"], maxAge = 3600)
@RestController
@RequestMapping("/api/proveedores")
@Tag(name = "proveedores")
class ProveedorRestController(
    override var serviceAPI: ProveedorServiceAPI,
    var productoServiceAPI: ProductoServiceAPI
) :
    GenericRestController<Proveedor, Int>(serviceAPI) {

    private val logger: Logger = LoggerFactory.getLogger(RequisitionRestController::class.java)


    override fun save(entity: Proveedor, result: BindingResult): ResponseEntity<*> {
        logger.info("Entity -> {}", entity.toString())
        return super.save(entity, result)
    }

    @PutMapping("/{id}/productos/cargar")
    fun cargarProductos(@RequestBody productos: List<Producto>, @PathVariable id: Int): ResponseEntity<Any> {
        val proveedor: Proveedor = serviceAPI.getOne(id)
        productos.forEach(proveedor::addProducto)
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviceAPI.save(proveedor))
    }

    @PutMapping("/{id}/productos/eliminar")
    fun eliminarProductos(@RequestBody producto: Producto, @PathVariable id: Int): ResponseEntity<Any> {
        val proveedor: Proveedor = serviceAPI.getOne(id)
        val producto1: Producto =
            this.productoServiceAPI.getOne(producto.idproducto!!)
        proveedor.removeProducto(producto1)
        return ResponseEntity.status(HttpStatus.OK).body(serviceAPI.save(proveedor))
    }

}