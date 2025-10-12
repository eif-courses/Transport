package lt.viko.eif.transport.appsas

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import lt.viko.eif.transport.appsas.ui.theme.TransportTheme

import lt.viko.eif.transport.appsas.view.drivers.DriverDetailsView
import lt.viko.eif.transport.appsas.view.drivers.DriversList

class MainActivity : ComponentActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransportTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation()
                    }
                }
            }
        }
    }
}



data object DriversListScreen
data class DriverDetailsScreen(val driverNumber: Int)


@Composable
fun AppNavigation() {
    val backStack = remember { mutableStateListOf<Any>(DriversListScreen) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { destination ->
            when (destination) {

                is DriversListScreen -> NavEntry(destination) {
                    DriversList(
                        onDriverClick = { driverNumber ->
                            backStack.add(DriverDetailsScreen(driverNumber))
                        }
                    )
                }

                is DriverDetailsScreen -> NavEntry(destination) {
                    DriverDetailsView(
                        driverNumber = destination.driverNumber,
                        onBack = { backStack.removeLastOrNull() }
                    )
                }

                else -> NavEntry(Unit) {
                    Text("Unknown route")
                }
            }
        }
    )
}



