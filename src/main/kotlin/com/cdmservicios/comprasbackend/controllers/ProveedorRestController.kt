package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.Producto
import com.cdmservicios.comprasbackend.models.Proveedor
import com.cdmservicios.comprasbackend.services.apis.ProductoServiceAPI
import com.cdmservicios.comprasbackend.services.apis.ProveedorServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/proveedores")
@Api(tags = ["proveedores"])
class ProveedorRestController(
    override var serviceAPI: ProveedorServiceAPI,
    var productoServiceAPI: ProductoServiceAPI
) :
    GenericRestController<Proveedor, Int>(serviceAPI) {

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