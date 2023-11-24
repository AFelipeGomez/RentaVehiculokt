package gca.net.RentaVehiculo.exception

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
@Order(Ordered.HIGHEST_PRECEDENCE)
class ExceptionHandlerGlobal : ResponseEntityExceptionHandler() {
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun manejarDataIntegrityViolationException(
            e: DataIntegrityViolationException,
            request: WebRequest
    ): ResponseEntity<ExceptionWrapper> {
        println("Ingreso DataIntegrityViolationException global")
        val ew = ExceptionWrapper(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.toString(),
                e.message,
                request.getDescription(false)
        )
        return ResponseEntity(ew, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    fun manejarNoHandlerFoundException(
            e:NoHandlerFoundException,
            request: WebRequest
    ): ResponseEntity<ExceptionWrapper> {
        println("Ingreso ManejadorNotFoudException global")
        val ew = ExceptionWrapper(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.toString(),
                "Ruta no encontrada, valide la información",
                request.getDescription(false)
        )
        return ResponseEntity(ew, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConflictException::class)
    fun manejarConflictException(
            e: ConflictException,
            request: WebRequest
    ): ResponseEntity<ExceptionWrapper> {
        println("Ingreso ConflicException manejador")
        val ew = ExceptionWrapper(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.toString(),
                e.message,
                request.getDescription(false)
        )
        return ResponseEntity(ew, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ModelNotFoundException::class)
    fun manejarModelNotFoundException(
            e: ModelNotFoundException,
            request: WebRequest
    ): ResponseEntity<ExceptionWrapper> {
        println("Ingreso modelnotfound global")
        val ew = ExceptionWrapper(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.toString(),
                e.message,
                request.getDescription(false)
        )
        return ResponseEntity(ew, HttpStatus.NOT_FOUND)
    }
}