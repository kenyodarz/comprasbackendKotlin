package com.cdmservicios.comprasbackend.controllers

import com.cdmservicios.comprasbackend.models.OrdenDeCompra
import com.cdmservicios.comprasbackend.models.Pedido
import com.cdmservicios.comprasbackend.services.apis.OrdenDeCompraServiceAPI
import com.cdmservicios.comprasbackend.shared.GenericRestController
import io.swagger.v3.oas.annotations.tags.Tag
import net.sf.jasperreports.engine.*
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.*
import java.io.IOException
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


@CrossOrigin(origins = ["*", "https://cdm-fs.com"], maxAge = 3600)
@RestController
@RequestMapping("/api/ordenes")
@Tag(name = "ordenes")
class OrdenDeCompraRestController(
    override var serviceAPI: OrdenDeCompraServiceAPI

) : GenericRestController<OrdenDeCompra, Int>(serviceAPI) {

    @GetMapping("por/{id}")
    fun findOrdenDeCompraByRequisition(@PathVariable id: Int): Iterable<Long> {
        return serviceAPI.findOrdenDeCompraByRequisition(id)
    }

    @GetMapping("{id}/pedidos")
    fun findPedidosByOrdenDeCompraAndProducto(@PathVariable id: Int): ResponseEntity<List<Pedido>> {
        return ResponseEntity.ok().body(
            serviceAPI.findPedidosByOrdenDeCompraAndProducto(id)
        )
    }

    override val all: List<OrdenDeCompra>
        get() = serviceAPI.findOrdenDeCompraGroupByProveedor()

    @GetMapping("/oco")
    fun findOrdenDeCompraGroupByProveedor(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(serviceAPI.findOrdenDeCompraGroupByProveedor())
    }

    @GetMapping("pdf/{id}")
    @Throws(JRException::class, IOException::class)
    fun verArchivo(@PathVariable id: Int): ResponseEntity<*>? {
        var con: Connection? = null
        try {
            Class.forName("org.postgresql.Driver")
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/REQUISICION", "postgres", "cdm")
        } catch (ignored: ClassNotFoundException) {
            ResponseEntity.internalServerError().body("ClassNotFoundException")
        } catch (ignored: SQLException) {
            ResponseEntity.internalServerError().body("SQLException")
        }
        val sourceFileName = ResourceUtils
            .getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "ORDEN_DE_COMPRA.jrxml")
            .absolutePath
        val jasperReport = JasperCompileManager.compileReport(sourceFileName)
        val parameters: MutableMap<String, Any> = HashMap()
        parameters["IDORDEN"] = id
        val jasperPrint: JasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con)
        val resource: Resource = ByteArrayResource(JasperExportManager.exportReportToPdf(jasperPrint))
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body<Any>(resource)
    }
}