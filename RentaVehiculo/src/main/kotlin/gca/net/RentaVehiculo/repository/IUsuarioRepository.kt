package gca.net.RentaVehiculo.repository

import gca.net.RentaVehiculo.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUsuarioRepository: JpaRepository<Usuario,Long> {

    fun existsByNombreUsuario(nombreUsuario: String): Boolean

    fun deleteByNombreUsuario(nombreUsuario: String)

    fun findByNombreUsuario(nombreUsuario: String) : Usuario
}