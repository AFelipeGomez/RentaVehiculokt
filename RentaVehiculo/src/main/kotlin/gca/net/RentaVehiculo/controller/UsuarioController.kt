package gca.net.RentaVehiculo.controller

import gca.net.RentaVehiculo.dto.UsuarioDto
import gca.net.RentaVehiculo.entity.Usuario
import gca.net.RentaVehiculo.exception.ConflictException
import gca.net.RentaVehiculo.service.IUsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController @Autowired constructor(

        private val service: IUsuarioService
) {
    @Throws(ConflictException::class)
    @PostMapping
    fun save(@RequestBody usuario: Usuario): ResponseEntity<Any> {
        service.save(usuario)
        return ResponseEntity(HttpStatus.CREATED)
    }


    @DeleteMapping("/{nombreUsuario}")
    fun  delete(@PathVariable nombreUsuario: String ) :ResponseEntity<Any> {
        service.delete(nombreUsuario)
        return  ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{nombreUsuario}")
    fun getByDocument(@PathVariable nombreUsuario: String):ResponseEntity<Any>{
        val usuarioDto = service.getByusuario(nombreUsuario)
        return ResponseEntity(usuarioDto,HttpStatus.OK)
    }

}