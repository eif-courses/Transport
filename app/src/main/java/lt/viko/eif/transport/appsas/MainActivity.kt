package lt.viko.eif.transport.appsas

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lt.viko.eif.transport.appsas.ui.theme.TransportTheme
import lt.viko.eif.transport.appsas.view.FruitsList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransportTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FruitsList()
                }
            }
        }
    }
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
fun PreviewNavigation(){

    val list = listOf("Button1", "Home", "Shop", "Deals")

    TransportTheme {
        CustomNavigation(list)
    }
}


@Composable
fun CustomNavigation(menuItems: List<String> ){

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



