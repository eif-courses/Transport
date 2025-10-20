package lt.viko.eif.transport.appsas.view.drivers

import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import lt.viko.eif.transport.appsas.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun DriverDetails(
    driverNumber: Int,
    onBack: () -> Unit,
    viewModel: DriversViewModel = koinViewModel()
) {

    val driver = viewModel.state.drivers.find { it.driverNumber == driverNumber }




    if (driver != null) {
        Text("" + driver.fullName)
    }

//        if (driver != null) {
//            AsyncImage(
//                model = driver.headshotUrl ?: R.drawable.baseline_person_outline_24,
//                contentDescription = driver.fullName,
//                modifier = Modifier.size(200.dp)
//            )
//        }

    Button(onClick = onBack) {
        Text("Grįžti atgal")
    }


}