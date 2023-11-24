package gca.net.RentaVehiculo.entity

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "renta_vehiculo")
data class RentaVehiculo(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long,

        @Column
        private var valor: Double,

        @OneToOne
        @JoinColumn(name = "id_medio_pago")
        private var medioPago: MedioPago,

        @Column(columnDefinition = "DATETIME")
        private var fechaInicio: LocalDateTime,

        @Column(columnDefinition = "DATETIME")
        private var fechaFinal: LocalDateTime,

        @OneToOne
        @JoinColumn(name = "id_estado")
        private var estadoRenta: EstadoRenta,


        @OneToOne
        @JoinColumn(name = "id_usuario")
        private var usuario: Usuario


        )
