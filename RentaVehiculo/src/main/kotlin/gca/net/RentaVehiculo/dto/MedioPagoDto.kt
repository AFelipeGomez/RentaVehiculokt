package gca.net.RentaVehiculo.dto

import com.fasterxml.jackson.annotation.JsonProperty
import gca.net.RentaVehiculo.entity.MedioPago
import org.springframework.stereotype.Component

@Component
data class MedioPagoDto(

    @JsonProperty("Id")
    var id: String,


    @JsonProperty("Medio Pago")
    var medioPago: String,

    @JsonProperty("Numero")
    var numero:String


) {

    constructor() : this("", "", "")

    fun fromMedioPagoToDto(medioPago: List<MedioPago>): List<MedioPagoDto> {
        return medioPago.map {
            MedioPagoDto(
                id = it.id.toString(),
                medioPago = it.tipoMedioPago.nombre,
                numero = it.numero
            )
        }
    }
}