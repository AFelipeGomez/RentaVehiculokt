package gca.net.RentaVehiculo.repository

import gca.net.RentaVehiculo.entity.RentaVehiculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface IRentaVehiculoRepository:JpaRepository<RentaVehiculo,Long> {

    @Query(value = "SELECT COUNT(*) FROM renta_vehiculo WHERE id_usuario = :usuarioId AND (id_estado = '1' OR id_estado ='3')", nativeQuery = true)
    fun countRentaByIdUsuario(@Param("usuarioId") usuarioId: Long): Int


}