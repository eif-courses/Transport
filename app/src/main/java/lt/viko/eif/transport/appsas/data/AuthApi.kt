package lt.viko.eif.transport.appsas.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST



data class User(
    val id: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val role: String,
    val isActive: Boolean,
    val createdAt: String? = null,
    val fullName: String = "$firstName $lastName",
    val authProvider: String = "email",    // Add this
    val hasBattleNet: Boolean = false      // Add this
)

// Update extensions to use the fields
fun User.hasBattleNetAccess(): Boolean {
    return hasBattleNet // Use the explicit field
}

fun User.getAuthProvider(): String {
    return authProvider // Use the explicit field
}



data class TokenData(
    val user: User,
    val accessToken: String
)

@JsonClass(generateAdapter = true)
data class SignInRequest(
    val email: String,
    val password: String
)


data class UserDto(
    @param:Json(name = "id")
    val id: String,
    @param:Json(name = "email")
    val email: String,
    @param:Json(name = "first_name")
    val firstName: String,
    @param:Json(name = "last_name")
    val lastName: String,
    @param:Json(name = "role")
    val role: String,
    @param:Json(name = "is_active")
    val isActive: Boolean,
    @param:Json(name = "created_at")
    val createdAt: String? = null
)


// Update extension function
fun UserDto.toDomainModel(authProvider: String, hasBattleNet: Boolean): User {
    return User(
        id = id,
        email = email,
        firstName = firstName,
        lastName = lastName,
        role = role,
        isActive = isActive,
        createdAt = createdAt,
        authProvider = authProvider,     // Add this
        hasBattleNet = hasBattleNet      // Add this
    )
}




data class UserResponse(

    @param:Json(name = "user")
    val user: UserDto,

    @param:Json(name = "auth_provider")
    val authProvider: String = "email",

    @param:Json(name = "has_battlenet")
    val hasBattlenet: Boolean = false,

    @param:Json(name = "outh_providers")
    val outhProviders: List<String> = emptyList()


)


@JsonClass(generateAdapter = true)
data class TokenResponse(
    @param:Json(name = "access_token")
    val accessToken: String,
    @param:Json(name = "user")
    val user: UserDto,
    @param:Json(name = "message")
    val message: String? = null, // Make this optional with default value
    @param:Json(name = "success")
    val success: Boolean? = null, // Make this optional too
    @param:Json(name = "token_type")
    val tokenType: String? = null, // Make this optional
    @param:Json(name = "expires_in")
    val expiresIn: Int? = null, // Make this optional
    @param:Json(name = "provider")
    val provider: String? = null // Make this optional
)


fun TokenResponse.toDomainModel(authProvider: String = "email", hasBattleNet: Boolean = false): TokenData {

    return TokenData(
        user = user.toDomainModel(authProvider, hasBattleNet), // Pass the auth provider info
        accessToken = accessToken
    )
}




interface AuthApi {

    @POST("api/v1/auth/login")
    suspend fun signIn(@Body request: SignInRequest): TokenResponse

    @GET("api/v1/auth/profile")
    suspend fun getCurrentUser(@Header("Authorization") authHeader: String) : UserResponse

}