package lt.viko.eif.transport.appsas.data.dto

import com.squareup.moshi.Json

data class F1DriversResponse(
    // moshi
    @param:Json(name="broadcast_name")
    val broadcastName: String?,

    @param:Json(name="country_code")
    val countryCode: String?,

    @param:Json(name="driver_number")
    val driverNumber: Int,

    @param:Json(name="first_name")
    val firstName: String?,

    @param:Json(name="full_name")
    val fullName: String?,

    @param:Json(name="headshot_url")
    val headshotUrl: String?,

    @param:Json(name="last_name")
    val lastName: String?,

    @param:Json(name="meeting_key")
    val meetingKey: Int,

    @param:Json(name="name_acronym")
    val nameAcronym: String?,

    @param:Json(name="session_key")
    val sessionKey: Int,

    @param:Json(name="team_colour")
    val teamColour: String?,

    @param:Json(name="team_name")
    val teamName: String?
)