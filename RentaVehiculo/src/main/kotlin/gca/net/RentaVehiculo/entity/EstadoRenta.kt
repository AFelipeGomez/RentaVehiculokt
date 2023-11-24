package gca.net.RentaVehiculo.entity

import jakarta.persistence.*

@Entity
@Table(name = "estado_renta")
data class EstadoRenta(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private var id: Long,


        @Column(name = "nombre", nullable = false, length = 50)
        private var nombre: String
)
