package gca.net.RentaVehiculo.service

import gca.net.RentaVehiculo.entity.MedioPago
import gca.net.RentaVehiculo.exception.ConflictException
import gca.net.RentaVehiculo.exception.ModelNotFoundException

interface IMedioPagoService {

    @Throws(ConflictException::class)
    fun save(medioPago: MedioPago)

    @Throws(ModelNotFoundException::class)
    fun getByUsuario(nombreUsuario:String):List<MedioPago>

    @Throws(ModelNotFoundException::class)
    fun deleteById(id:Long)

    fun update(medioPago: MedioPago)


}