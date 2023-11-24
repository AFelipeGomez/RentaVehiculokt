package gca.net.RentaVehiculo.exception

import java.time.LocalTime

class ExceptionWrapper private constructor() {


    var timestamp: LocalTime? = null
        private set

    var status: Int = 0
        private set

    var error: String? = null
        private set

    var message: String? = null
        private set

    var path: String? = null
        private set

    constructor(status: Int, error: String, message: String?, path: String) : this() {
        this.timestamp = LocalTime.now()
        this.status = status
        this.error = error
        this.message = message
        this.path = path
    }
}