package gca.net.RentaVehiculo.dto

import com.fasterxml.jackson.annotation.JsonProperty
import gca.net.RentaVehiculo.entity.MedioPago

data class UsuarioDto(
        @JsonProperty("Nombre")
        var nombre: String,

        @JsonProperty("Apellido")
        var apellido: String,

        @JsonProperty("Documento")
        var documento: String,
        @JsonProperty("Direccion")
        var direccion: String,
        @JsonProperty("NickName")
        var nombreUsuario: String,
        var medioPago: List<MedioPago>


) {
    constructor() : this("", "", "", "", "", emptyList())
}
