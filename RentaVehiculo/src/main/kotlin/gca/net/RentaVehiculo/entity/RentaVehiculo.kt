package gca.net.RentaVehiculo.entity

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "renta_vehiculo")
data class RentaVehiculo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column
    var valor: Double,

    @OneToOne
    @JoinColumn(name = "id_medio_pago")
    var medioPago: MedioPago,

    @Column(columnDefinition = "DATETIME")
    var fechaInicio: LocalDateTime? = null,

    @Column(columnDefinition = "DATETIME")
    var fechaFinal: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "id_estado")
    var estadoRenta: EstadoRenta? = null,


    @OneToOne
    @JoinColumn(name = "id_usuario")
    var usuario: Usuario


)
