package gca.net.RentaVehiculo.entity

import jakarta.persistence.*

@Entity
@Table(name = "medio_pago")
data class MedioPago(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @Column(name = "numero", nullable = false, length = 50)
        var numero: String, // Por ejemplo,9874256984931688

        @ManyToOne
        @JoinColumn(name = "id_tipo_medio_pago")
        var tipoMedioPago: TipoMedioPago,

        @ManyToOne
        @JoinColumn(name = "id_usuario", nullable = false)
        var usuario: Usuario

)
