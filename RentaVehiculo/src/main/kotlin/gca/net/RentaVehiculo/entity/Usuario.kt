package gca.net.RentaVehiculo.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "usuario")
data class Usuario(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @Column(name = "nombre", nullable = false, length = 50)
        var nombre: String,

        @Column(name = "apellido", nullable = false, length = 50)
        var apellido: String,

        @Column(name = "documento", nullable = false, length = 25)
        var documento: String,

        @Column(name = "direccion", nullable = false, length = 50)
        var direccion: String,

        @Column(name = "nombreUsuario", nullable = false, length = 50)
        var nombreUsuario: String,

        @Column(name = "clave", nullable = false, length = 150)
        var clave: String,

        @Column(columnDefinition = "DATETIME")
        var fechaRegistro: LocalDateTime,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "usuario", orphanRemoval = true)
        var medioPago: List<MedioPago>

)
