package gca.net.RentaVehiculo.controller

import gca.net.RentaVehiculo.dto.RentaVehiculoDto
import gca.net.RentaVehiculo.entity.RentaVehiculo
import gca.net.RentaVehiculo.service.IRentaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/RentaVehiculo")
class RentaVehiculoController @Autowired constructor(
    private var service: IRentaService,
    private var transfer: RentaVehiculoDto
) {


    @PostMapping
    fun save(@RequestBody rentaVehiculo: RentaVehiculo): ResponseEntity<Any> {
        service.save(rentaVehiculo)

        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping("/{idRenta}")
    fun getByIdRenta(@PathVariable idRenta: Long): ResponseEntity<Any> {

        val RentaVehiculoDto = transfer.fromRentaToDto(service.getByIdRenta(idRenta))

        return ResponseEntity(RentaVehiculoDto, HttpStatus.OK)
    }

    @GetMapping
    fun getAllRenta(): ResponseEntity<Any> {

        val rentaVehiculo = service.all()

        return ResponseEntity(rentaVehiculo.map { transfer.fromRentaToDto(it) }, HttpStatus.OK)
    }
}