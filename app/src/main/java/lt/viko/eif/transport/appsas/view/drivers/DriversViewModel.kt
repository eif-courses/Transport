package lt.viko.eif.transport.appsas.view.drivers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lt.viko.eif.transport.appsas.data.F1DriversRepository
import lt.viko.eif.transport.appsas.data.F1DriversResponse

class DriversViewModel(private val repository: F1DriversRepository) : ViewModel() {

    var state by mutableStateOf(DriversState())
        private set


    init {
        getAllF1rivers()
    }

    fun getAllF1rivers() {

        viewModelScope.launch {
            state = state.copy(
                drivers = repository.getAllDrivers()
            )
        }

    }




}

data class DriversState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val drivers: List<F1DriversResponse> = emptyList()
)