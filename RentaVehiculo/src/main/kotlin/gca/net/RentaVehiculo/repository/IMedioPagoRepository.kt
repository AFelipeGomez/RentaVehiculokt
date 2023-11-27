package gca.net.RentaVehiculo.repository

import gca.net.RentaVehiculo.entity.MedioPago
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface IMedioPagoRepository: JpaRepository<MedioPago,Long> {
    @Query(value = "SELECT  COUNT(*) FROM medio_pago WHERE id_usuario = :usuarioId AND numero LIKE :numero", nativeQuery = true)
    fun countByUsuarioIdAndTipoIgnoreCase(@Param("usuarioId") usuarioId: Long, @Param("numero") tipoMedioPago: String): Int

    @Query(value = "SELECT * FROM medio_pago WHERE id_usuario = :usuarioId ", nativeQuery = true)
    fun findAllByIdUsuario(@Param("usuarioId") usuarioId: Long): List<MedioPago>
}