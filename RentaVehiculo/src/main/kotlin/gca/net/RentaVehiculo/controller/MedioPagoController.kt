package gca.net.RentaVehiculo.controller

import gca.net.RentaVehiculo.dto.MedioPagoDto
import gca.net.RentaVehiculo.entity.MedioPago
import gca.net.RentaVehiculo.exception.ConflictException
import gca.net.RentaVehiculo.service.IMedioPagoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/MedioPago")
class MedioPagoController @Autowired constructor(

        private var service: IMedioPagoService,
    private val transfer:MedioPagoDto
){

    @Throws(ConflictException::class)
    @PostMapping
    fun save(@RequestBody medioPago: MedioPago): ResponseEntity<Any> {
        service.save(medioPago)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/{idMedioPago}")
    fun  delete(@PathVariable idMedioPago: Long ) :ResponseEntity<Any> {
        service.deleteById(idMedioPago)
        return  ResponseEntity( "Medio de pago eliminado",HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{idUsuario}")
    fun getByUsuario(@PathVariable idUsuario: Long):ResponseEntity<Any>{
        //val usuarioDto = service.getByusuario(nombreUsuario)
        return ResponseEntity(transfer.fromMedioPagoToDto(service.getByIdUsuario(idUsuario)),HttpStatus.OK)
    }


}