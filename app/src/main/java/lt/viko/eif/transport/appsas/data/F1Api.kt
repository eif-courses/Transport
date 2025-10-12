package lt.viko.eif.transport.appsas.data

import com.squareup.moshi.Json
import retrofit2.http.GET


class Ret() {
}


data class F1DriversResponse(
    @param:Json(name = "broadcast_name")
    val broadcastName: String?,

    @param:Json(name = "country_code")
    val countryCode: String?,

    @param:Json(name = "driver_number")
    val driverNumber: Int,

    @param:Json(name = "first_name")
    val firstName: String?,

    @param:Json(name = "full_name")
    val fullName: String?,

    @param:Json(name = "headshot_url")
    val headshotUrl: String?,

    @param:Json(name = "last_name")
    val lastName: String?,

    @param:Json(name = "meeting_key")
    val meetingKey: Int,

    @param:Json(name = "name_acronym")
    val nameAcronym: String?,

    @param:Json(name = "session_key")
    val sessionKey: Int,

    @param:Json(name = "team_colour")
    val teamColour: String?,

    @param:Json(name = "team_name")
    val teamName: String?
)


interface F1Api {

    //https://api.openf1.org/v1/drivers

    @GET("v1/drivers")
    suspend fun getAllF1Drivers(): List<F1DriversResponse>


}