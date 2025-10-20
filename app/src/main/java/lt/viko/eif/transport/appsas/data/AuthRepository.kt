package lt.viko.eif.transport.appsas.data

interface AuthRepository {

    suspend fun signIn(email: String, password: String): TokenData
    suspend fun signOut()
    suspend fun getCurrentUser(): String?
    suspend fun getCurrentToken(): String?
    suspend fun isUserSignedIn(): Boolean

}