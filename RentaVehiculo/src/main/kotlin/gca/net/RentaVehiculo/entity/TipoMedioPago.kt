package gca.net.RentaVehiculo.entity
import jakarta.persistence.*
@Entity
@Table(name = "tipo_medio_pago")
data class TipoMedioPago(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
       var id: Long,

        @Column(name = "nombre", nullable = false, length = 50)
        var nombre: String //Ejemplo "Tarjeta Credito"
)
