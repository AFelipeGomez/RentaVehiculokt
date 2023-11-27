package gca.net.RentaVehiculo.dto

import com.fasterxml.jackson.annotation.JsonProperty
import gca.net.RentaVehiculo.entity.MedioPago
import gca.net.RentaVehiculo.entity.RentaVehiculo
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
data class RentaVehiculoDto(

    @JsonProperty("Id")
    var id: String,

    @JsonProperty("Valor")
    var valor: String,

    @JsonProperty("Medio Pago")
    var medioPago: String,

    @JsonProperty("Fecha Inicio")
    var fechaInicio: String,

    @JsonProperty("Fecha Final")
    var fechaFinal: String,

    @JsonProperty("Estado")
    var estadoRenta: String
){
    constructor(): this ("","","","","","")

    fun fromRentaToDto(rentaVehiculo:RentaVehiculo):RentaVehiculoDto{
        return RentaVehiculoDto(
            id = rentaVehiculo.id.toString(),
            valor = rentaVehiculo.valor.toString(),
            medioPago= rentaVehiculo.medioPago.tipoMedioPago.nombre,
            fechaInicio=rentaVehiculo.fechaInicio.toString() ?: "",
            fechaFinal=rentaVehiculo.fechaFinal.toString()?: "",
            estadoRenta= rentaVehiculo.estadoRenta?.nombre.toString()
        )
    }

}
