package lt.viko.eif.transport.appsas.data

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET



class Ret(){
}


data class F1DriversResponse(
    @SerializedName("broadcast_name")
    val broadcastName: String,

    @SerializedName("country_code")
    val countryCode: String,

    @SerializedName("driver_number")
    val driverNumber: Int,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("headshot_url")
    val headshotUrl: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("meeting_key")
    val meetingKey: Int,

    @SerializedName("name_acronym")
    val nameAcronym: String,

    @SerializedName("session_key")
    val sessionKey: Int,

    @SerializedName("team_colour")
    val teamColour: String,

    @SerializedName("team_name")
    val teamName: String
)


interface F1Api {

    //https://api.openf1.org/v1/drivers

    @GET("v1/drivers")
    suspend fun getAllF1Drivers(): List<F1DriversResponse>


}