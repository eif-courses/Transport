package lt.viko.eif.transport.appsas.data

interface F1DriversRepository {
    suspend fun getAllDrivers(): List<F1DriversResponse>
}