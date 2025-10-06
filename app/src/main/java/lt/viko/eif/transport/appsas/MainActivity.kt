package lt.viko.eif.transport.appsas

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import lt.viko.eif.transport.appsas.view.drivers.DriversList

class MainActivity : ComponentActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransportTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    context = LocalContext.current

                    DriversList()

                    // FruitsList(context)
                    //NavExample()
                }
            }
        }
    }
}


data object Home
data class Product(val id: String)


data class About(val message: String)

@Composable
fun NavExample() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { obj->
            when (obj) {
                is Home -> NavEntry(obj) {

                    Column {
                        Button(onClick = {
                            backStack.add(Product("123"))
                        }) {
                            Text("Click to navigate")
                        }

                        Button(onClick = {
                            backStack.add(About("About page"))
                        }) {
                            Text("Click to navigate to about")
                        }
                    }
                }

                is Product -> NavEntry(obj) {
                    ContentBlue("Product ${obj.id} ")
                }
                is About -> NavEntry(obj){
                    Text(obj.message)
                    Button(onClick = {
                          backStack.removeLastOrNull()
                    }) {
                        Text("back")
                    }
                }


                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}

@Composable
fun ContentBlue(x0: String) {
    Text(x0)
}


@Composable
fun ContentGreen(x0: String, content: @Composable () -> Unit) {
    Text(x0)
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TransportTheme {

        Row {
            Greeting("Android")
            Text("Labas")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewNavigation() {

    val list = listOf("Button1", "Home", "Shop", "Deals")

    TransportTheme {
        CustomNavigation(list)
    }
}


@Composable
fun CustomNavigation(menuItems: List<String>) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(menuItems) { item ->
            Button(onClick = {
                println(item)
            }) {
                Text(item)
            }
        }
    }

}



