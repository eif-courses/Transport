package lt.viko.eif.transport.appsas.data

import lt.viko.eif.transport.appsas.data.dto.F1DriversResponse
import retrofit2.http.GET


interface F1Api {

    //https://api.openf1.org/v1/drivers

    @GET("v1/drivers")
    suspend fun getAllF1Drivers(): List<F1DriversResponse>


}