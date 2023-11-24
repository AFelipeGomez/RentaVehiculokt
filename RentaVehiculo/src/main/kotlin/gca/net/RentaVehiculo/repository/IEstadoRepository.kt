package gca.net.RentaVehiculo.repository

import gca.net.RentaVehiculo.entity.EstadoRenta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IEstadoRepository: JpaRepository<EstadoRenta,Long> {
}