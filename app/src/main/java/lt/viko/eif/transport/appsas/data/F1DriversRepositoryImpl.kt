package lt.viko.eif.transport.appsas.data

import lt.viko.eif.transport.appsas.data.dto.F1DriversResponse


class F1DriversRepositoryImpl(private val api: F1Api) : F1DriversRepository {

    override suspend fun getAllDrivers(): List<F1DriversResponse> {
        return api.getAllF1Drivers()
    }
}