package lt.viko.eif.transport.appsas.view.auth

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lt.viko.eif.transport.appsas.data.AuthRepository
import lt.viko.eif.transport.appsas.data.User
import lt.viko.eif.transport.appsas.di.TokenStorage

class AuthViewModel(
    private val authRepository: AuthRepository,
    private val storage: TokenStorage
) : ViewModel() {

    var uiState by mutableStateOf(SignInState())


    fun signIn(email: String, password: String){

        viewModelScope.launch {

            val result = authRepository.signIn(email, password)

            uiState = uiState.copy(
                isLoading = false,
                user = result.user,
                token = storage.getToken()
            )

        }

    }




}

data class SignInState(
    val isLoading: Boolean = false,
    val error :String? = null,
    val user : User? = null,
    val token: String? = null
)
