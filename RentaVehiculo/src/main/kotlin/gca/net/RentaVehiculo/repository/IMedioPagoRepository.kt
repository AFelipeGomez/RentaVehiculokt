package gca.net.RentaVehiculo.repository

import gca.net.RentaVehiculo.entity.MedioPago
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IMedioPagoRepository: JpaRepository<MedioPago,Long> {
}