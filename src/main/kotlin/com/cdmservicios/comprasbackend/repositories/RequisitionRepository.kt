package com.cdmservicios.comprasbackend.repositories

import com.cdmservicios.comprasbackend.models.Requisition
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RequisitionRepository : JpaRepository<Requisition, Int> {


    @Query(
        value = "select req.idrequisicion, req.numerorequisicion, req.referencia, req.fechaderegistro, req.idusuario, req.idcentrodecostos, req.observaciones, count(ped.*) as totales, count(ped.*)-count(oc.*) as pendientes from requisicion req inner join pedidos ped on ped.idrequisicion=req.idrequisicion left join ordendecompra oc on oc.idordendecompra=ped.idordendecompra group by req.idrequisicion",
        nativeQuery = true
    )
    fun findAllRequisition(): List<Requisition>

}