package gca.net.RentaVehiculo.service

import gca.net.RentaVehiculo.entity.RentaVehiculo
import gca.net.RentaVehiculo.exception.ConflictException
import gca.net.RentaVehiculo.exception.ModelNotFoundException
import java.util.*

interface IRentaService {

    @Throws(ConflictException::class)
    fun save(rentaVehiculo: RentaVehiculo)


    @Throws(ModelNotFoundException::class)
    fun getByIdRenta(idRenta:Long): RentaVehiculo


    fun all():List<RentaVehiculo>


}