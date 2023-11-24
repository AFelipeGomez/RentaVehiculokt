package gca.net.RentaVehiculo.repository

import gca.net.RentaVehiculo.entity.RentaVehiculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IRentaVehiculoRepository:JpaRepository<RentaVehiculo,Long> {
}