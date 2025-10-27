package lt.viko.eif.transport.appsas.data

import lt.viko.eif.transport.appsas.di.TokenStorage
import lt.viko.eif.transport.appsas.di.authModule

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val tokenStorage: TokenStorage
) : AuthRepository {


    override suspend fun signIn(
        email: String,
        password: String
    ): TokenData {

        val request = SignInRequest(email = email, password = password)
        val response = api.signIn(request)
        val tokenData = response.toDomainModel()

        tokenStorage.saveToken(tokenData.accessToken)

        return tokenData;

    }

    override suspend fun signOut() {
        tokenStorage.clearToken()
    }

    override suspend fun getCurrentUser(): User? {

        val token = tokenStorage.getToken()

        val response: UserResponse = api.getCurrentUser("Bearer $token")

        val result = response.user.toDomainModel(
            authProvider = response.authProvider,
            hasBattleNet = response.hasBattlenet
        )

        return result

    }

    override suspend fun getCurrentToken(): String? {
        return tokenStorage.getToken()
    }

    override suspend fun isUserSignedIn(): Boolean {
        return tokenStorage.hasValidToken()
    }
}