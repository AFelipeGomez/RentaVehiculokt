package gca.net.RentaVehiculo.dto

import gca.net.RentaVehiculo.entity.TipoMedioPago
import gca.net.RentaVehiculo.entity.Usuario

data class MedioPagoDto(
        private var id:Long,
        private var nombreUsuario:String,
        private var medioPago: TipoMedioPago

)
