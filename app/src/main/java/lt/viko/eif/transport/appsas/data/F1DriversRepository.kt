package lt.viko.eif.transport.appsas.data

import lt.viko.eif.transport.appsas.data.dto.F1DriversResponse

interface F1DriversRepository {
    suspend fun getAllDrivers(): List<F1DriversResponse>
}