package lt.viko.eif.transport.appsas.data

import lt.viko.eif.transport.appsas.di.TokenStorage

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val tokenStorage: TokenStorage
) : AuthRepository {


    override suspend fun signIn(
        email: String,
        password: String
    ): TokenData {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentUser(): String? {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentToken(): String? {
        TODO("Not yet implemented")
    }

    override suspend fun isUserSignedIn(): Boolean {
        TODO("Not yet implemented")
    }
}