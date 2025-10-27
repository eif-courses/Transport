package lt.viko.eif.transport.appsas.di

import android.app.Application
import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import lt.viko.eif.transport.appsas.data.AuthApi
import lt.viko.eif.transport.appsas.data.AuthRepository
import lt.viko.eif.transport.appsas.data.AuthRepositoryImpl
import lt.viko.eif.transport.appsas.data.F1Api
import lt.viko.eif.transport.appsas.data.F1DriversRepository
import lt.viko.eif.transport.appsas.data.F1DriversRepositoryImpl
import lt.viko.eif.transport.appsas.view.auth.AuthViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.coroutines.EmptyCoroutineContext.get


interface TokenStorage {
    suspend fun saveToken(token: String)
    suspend fun getToken(): String?
    suspend fun clearToken()
    suspend fun hasValidToken(): Boolean
}



val authModule = module{

single<TokenStorage> {
        object : TokenStorage {
            private val prefs = get<Application>().getSharedPreferences("debug_auth", Context.MODE_PRIVATE)

            override suspend fun saveToken(token: String) {
                println("💾 DEBUG: Saving token: ${token.take(20)}...")
                val success = prefs.edit().putString("auth_token", token).commit()
                println("💾 DEBUG: Save result = $success")

                // Verify immediately
                val saved = prefs.getString("auth_token", null)
                println("💾 DEBUG: Immediate verification: ${saved?.take(20)}...")
            }

            override suspend fun getToken(): String? {
                val token = prefs.getString("auth_token", null)
                println("🔍 DEBUG: Retrieved token: ${token?.take(20)}...")
                return token
            }

            override suspend fun clearToken() {
                prefs.edit().remove("auth_token").commit()
                println("🧹 DEBUG: Token cleared")
            }

            override suspend fun hasValidToken(): Boolean {
                val token = getToken()
                val isValid = token != null && token.isNotBlank()
                println("🔍 DEBUG: hasValidToken = $isValid")
                return isValid
            }
        }
    }


    single<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    // Base Retrofit instance - used across all features
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://minigameapi-production.up.railway.app/")
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .build()
    }



    single<AuthApi> {
        get<Retrofit>().create(AuthApi::class.java)
    }

    single<AuthRepository> {
        AuthRepositoryImpl(api = get(), tokenStorage = get())
    }

    viewModelOf(::AuthViewModel)





}