package gca.net.RentaVehiculo.service

import gca.net.RentaVehiculo.entity.RentaVehiculo
import gca.net.RentaVehiculo.exception.ModelNotFoundException
import gca.net.RentaVehiculo.repository.IRentaVehiculoRepository
import gca.net.RentaVehiculo.repository.ITipoMedioPagoRepository
import gca.net.RentaVehiculo.repository.IUsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class RentaVehiculoServiceImpl @Autowired constructor(
    private var repository: IRentaVehiculoRepository,
    private var repositoryUsuario: IUsuarioRepository,
    private var repositoryMedioPago: ITipoMedioPagoRepository
) : IRentaService {
    override fun save(rentaVehiculo: RentaVehiculo) {
        validarUsuario(rentaVehiculo.usuario.id)
        validarRentaUsuario(rentaVehiculo.usuario.id)
        //validadMedioPago(rentaVehiculo.medioPago.id)

        repository.save(rentaVehiculo)

    }

    override fun getByIdRenta(idRenta: Long): RentaVehiculo {


        val rentaVehiculo = repository.findById(idRenta)

        if (rentaVehiculo.isPresent) return rentaVehiculo.get()
        else throw ModelNotFoundException("No existe renta con el id '$idRenta'.")

    }

    override fun all(): List<RentaVehiculo> {
        return repository.findAll()
    }

    private fun validarRentaUsuario(idUsuario: Long) {

        if (repository.countRentaByIdUsuario(idUsuario) > 0) {
            throw ModelNotFoundException("El usuario ya tiene un proceso de renta")
        }
    }

    private fun validarUsuario(idUsuario: Long) {
        if (!repositoryUsuario.existsById(idUsuario)) {
            throw ModelNotFoundException("Id de usuario no existe")
        }
    }

    private fun validadMedioPago(idMedioPago: Long) {
        if (!repositoryMedioPago.existsById(idMedioPago)) {
            throw ModelNotFoundException("Id '$idMedioPago' de Medio de Pago no existe")
        }
    }

    private fun validarRenta(idRenta: Long) {
        if (!repository.existsById(idRenta)) {
            throw ModelNotFoundException("Id Renta Vehiculo no existe")
        }
    }

}