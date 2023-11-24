package gca.net.RentaVehiculo.service.impl

import gca.net.RentaVehiculo.dto.MedioPagoDto
import gca.net.RentaVehiculo.dto.UsuarioDto
import gca.net.RentaVehiculo.entity.TipoMedioPago
import gca.net.RentaVehiculo.entity.Usuario
import gca.net.RentaVehiculo.exception.ConflictException
import gca.net.RentaVehiculo.exception.ModelNotFoundException
import gca.net.RentaVehiculo.repository.IMedioPagoRepository
import gca.net.RentaVehiculo.repository.IUsuarioRepository
import gca.net.RentaVehiculo.service.IUsuarioService
import jakarta.annotation.PostConstruct
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDateTime

@Service
class UsuarioServiceImpl @Autowired constructor(
        private var repositoryUsuario: IUsuarioRepository,
        private var repositoryMedioPagoRepository: IMedioPagoRepository) : IUsuarioService {

    private var modelMapper = ModelMapper()


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
    override fun getByusuario(nombreUsuario: String): UsuarioDto {
        if (!validarNombreUsuario(nombreUsuario)) {
            throw ModelNotFoundException("Usuario no encontrado")
        }
        return transferirDto(repositoryUsuario.findByNombreUsuario(nombreUsuario))
    }

    fun validarNombreUsuario(nombreUsuario: String): Boolean {
        return repositoryUsuario.existsByNombreUsuario(nombreUsuario)
    }

    private fun transferirDto(usuario: Usuario): UsuarioDto {
        return modelMapper.map(usuario, UsuarioDto::class.java)

    }

    @PostConstruct
    fun configureModelMapper() {
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        // Configuración de un convertidor para LocalDateTime
        modelMapper.addConverter { ctx ->
            if (ctx.source != null) {
                Timestamp.valueOf(ctx.source as LocalDateTime?)
            } else {
                null
            }
        }
    }
}