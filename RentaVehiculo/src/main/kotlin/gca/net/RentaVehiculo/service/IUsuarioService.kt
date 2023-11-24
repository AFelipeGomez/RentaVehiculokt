package gca.net.RentaVehiculo.service


import gca.net.RentaVehiculo.dto.UsuarioDto
import gca.net.RentaVehiculo.entity.TipoMedioPago
import gca.net.RentaVehiculo.entity.Usuario
import gca.net.RentaVehiculo.exception.ConflictException
import gca.net.RentaVehiculo.exception.ModelNotFoundException



interface IUsuarioService {
    @Throws(ConflictException::class)
    fun save(usuario: Usuario)

    @Throws(ModelNotFoundException::class)
    fun update(medioPago: TipoMedioPago)

    @Throws(ModelNotFoundException::class)
    fun delete(nombreUsuario: String)

    @Throws(ModelNotFoundException::class)
    fun getByusuario(nombreUsuario: String): UsuarioDto
}