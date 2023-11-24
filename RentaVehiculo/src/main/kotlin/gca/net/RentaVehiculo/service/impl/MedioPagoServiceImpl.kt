package gca.net.RentaVehiculo.service.impl

import gca.net.RentaVehiculo.entity.MedioPago

import gca.net.RentaVehiculo.entity.Usuario
import gca.net.RentaVehiculo.exception.DataIntegrityViolationException
import gca.net.RentaVehiculo.exception.ModelNotFoundException
import gca.net.RentaVehiculo.repository.IMedioPagoRepository
import gca.net.RentaVehiculo.repository.IUsuarioRepository
import gca.net.RentaVehiculo.service.IMedioPagoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MedioPagoServiceImpl @Autowired constructor(
        private var repository: IMedioPagoRepository,
        private var repostoryUsuario: IUsuarioRepository) : IMedioPagoService {
    override fun save(medioPago: MedioPago) {
        validarUsuarioId(medioPago.usuario.id)
        validarExistenciaMedioPago(medioPago.usuario.id, medioPago.numero)
        validarUsuarioId(medioPago.usuario.id)
        repository.save(medioPago)

    }

    override fun getByIdUsuario(idUsuario: Long): List<MedioPago> {
        return repository.findAllByIdUsuario(idUsuario)


    }


    override fun deleteById(id: Long) {
        validarIdMedioPago(id)
        repository.deleteById(id)
    }

    override fun update(medioPago: MedioPago) {
        TODO("Not yet implemented")
    }

    private fun validarUsuarioId(usuarioId: Long?) {
        if (usuarioId == null) {
            throw ModelNotFoundException("El id de usuario es requerido")
        }
    }

    private fun validarExistenciaMedioPago(usuarioId: Long, numero: String) {
        if (repository.countByUsuarioIdAndTipoIgnoreCase(usuarioId, numero)) {
            throw DataIntegrityViolationException("El medio de pago ya está registrado")
        }
    }

    private fun obtenerUsuarioExistente(usuarioId: Long): Usuario {
        return repostoryUsuario.findById(usuarioId)
                .orElseThrow { ModelNotFoundException("El usuario no existe") }
    }

    private fun validarIdMedioPago(idMedioPago:Long){
        if(!repository.existsById(idMedioPago)){
            throw ModelNotFoundException("El id del medio de pago a eliminar no existe")
        }
    }



}