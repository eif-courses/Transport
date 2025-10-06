package lt.viko.eif.transport.appsas.view.drivers

import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel




data class Person(val name: String, val age: Int)




@Composable
fun DriversList(viewModel: DriversViewModel = koinViewModel()) {


    var d = Person("Marius", 24)

    print(d)

    LazyColumn {
        items(viewModel.state.drivers) { driver ->
            Text("VAISIUS: " + driver)
        }
    }
}
