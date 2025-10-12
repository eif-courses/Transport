package lt.viko.eif.transport.appsas.view.drivers

import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel


@Composable
fun DriversList(viewModel: DriversViewModel = koinViewModel()) {

    LazyColumn {
        items(viewModel.state.drivers) { driver ->
            Text("VAISIUS: " + driver.driverNumber)
        }
    }
}
