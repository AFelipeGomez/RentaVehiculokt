package gca.net.RentaVehiculo.service.impl



import gca.net.RentaVehiculo.entity.TipoMedioPago
import gca.net.RentaVehiculo.entity.Usuario
import gca.net.RentaVehiculo.exception.ConflictException
import gca.net.RentaVehiculo.exception.ModelNotFoundException

import gca.net.RentaVehiculo.repository.IUsuarioRepository
import gca.net.RentaVehiculo.service.IUsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class UsuarioServiceImpl @Autowired constructor(
        private var repositoryUsuario: IUsuarioRepository) : IUsuarioService {




    @Throws(ConflictException::class)
    override fun save(usuario: Usuario) {
        if (validarNombreUsuario(usuario.nombreUsuario)) {
            throw ConflictException("Usuario ya existe")
        }
        usuario.medioPago?.forEach { dc ->
            dc.usuario = usuario
        }

        repositoryUsuario.save(usuario)
    }

    override fun all(): List<Usuario> {
        return repositoryUsuario.findAll()
    }


    override fun update(medioPago: TipoMedioPago) {
        TODO("Not yet implemented")
    }

    @Throws(ModelNotFoundException::class)
    override fun delete(nombreUsuario: String) {
        if (validarNombreUsuario(nombreUsuario)) {
            repositoryUsuario.deleteByNombreUsuario(nombreUsuario)
        } else {
            throw ModelNotFoundException("Usuario no encontrado")
        }
    }

    @Throws(ModelNotFoundException::class)
    override fun getByusuario(nombreUsuario: String): Usuario {
        if (!validarNombreUsuario(nombreUsuario)) {
            throw ModelNotFoundException("Usuario no encontrado")
        }
        return repositoryUsuario.findByNombreUsuario(nombreUsuario)
    }

    fun validarNombreUsuario(nombreUsuario: String): Boolean {
        return repositoryUsuario.existsByNombreUsuario(nombreUsuario)
    }




}