package gca.net.RentaVehiculo.repository

import gca.net.RentaVehiculo.entity.TipoMedioPago
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ITipoMedioPagoRepository:JpaRepository<TipoMedioPago,Long> {
}