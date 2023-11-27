package gca.net.RentaVehiculo.dto

import com.fasterxml.jackson.annotation.JsonProperty
import gca.net.RentaVehiculo.entity.MedioPago

import gca.net.RentaVehiculo.entity.Usuario
import org.springframework.stereotype.Component

@Component
data class UsuarioDto(
    @JsonProperty("Id")
    var id :String,

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

    @JsonProperty("MediosDePago")
    var medioPago: List<MedioPagoDto>? = null


) {
    constructor() : this("", "", "", "", "","", emptyList())


    fun fromUsuarioToDto(usuario: Usuario): UsuarioDto {
        return UsuarioDto(
            id=usuario.id.toString(),
            nombre = usuario.nombre.toString(),
            apellido = usuario.apellido.toString(),
            documento = usuario.documento.toString(),
            direccion = usuario.direccion.toString(),
            nombreUsuario = usuario.nombreUsuario.toString(),
            medioPago = usuario.medioPago.map {
                MedioPagoDto(
                    id = it.id.toString()?:"",
                    numero = it.numero?:"",
                    medioPago = it.tipoMedioPago.nombre.toString()?:""
                )
            } ?: emptyList()

        )
    }

    fun fromUsuarioListToDtoList(usuarios: List<Usuario>?): List<UsuarioDto> {
        return usuarios?.map { fromUsuarioToDto(it) } ?: emptyList()
    }

}
