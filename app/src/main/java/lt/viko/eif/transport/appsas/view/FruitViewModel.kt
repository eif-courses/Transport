package lt.viko.eif.transport.appsas.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lt.viko.eif.transport.appsas.data.FruitRepository

class FruitViewModel(
    private val fruitRepository: FruitRepository
) : ViewModel() {

    var state by mutableStateOf(FruitState())
        private set


    init {
        getAllFruits()
    }

    fun getAllFruits() {

        viewModelScope.launch {

            state.copy(
                fruits = fruitRepository.listFruits()
            )
        }
    }


}


data class FruitState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val fruits: List<String> = emptyList()
)