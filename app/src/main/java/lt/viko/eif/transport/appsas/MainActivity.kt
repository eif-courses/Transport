package lt.viko.eif.transport.appsas

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import lt.viko.eif.transport.appsas.ui.theme.TransportTheme
import lt.viko.eif.transport.appsas.view.FruitsList
import lt.viko.eif.transport.appsas.view.auth.SignInScreen
import lt.viko.eif.transport.appsas.view.drivers.DriverDetails
import lt.viko.eif.transport.appsas.view.drivers.DriversList

class MainActivity : ComponentActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransportTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    SignInScreen()
//                    context = LocalContext.current
//                    Box(modifier = Modifier.padding(innerPadding))    {
//                        AppNavigation()
//                    }

                }
            }
        }
    }
}


data object DriverListScreen
data class DriverDetailsScreen(val driverNumber: Int)


@Composable
fun AppNavigation() {

    val backStack = remember { mutableStateListOf<Any>(DriverListScreen) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { destination ->
            when (destination) {

                is DriverListScreen -> NavEntry(destination){
                    DriversList(
                        onDriverClick = { driverNumber ->
                            backStack.add(DriverDetailsScreen(driverNumber))
                        }
                    )
                }

                is DriverDetailsScreen -> NavEntry(destination){
                    DriverDetails(
                        driverNumber = destination.driverNumber,
                        onBack = { backStack.removeLastOrNull()}
                    )
                }


                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}





