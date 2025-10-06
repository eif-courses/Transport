package lt.viko.eif.transport.appsas.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel


@Composable
fun FruitsList(context: Context, fruitViewModel: FruitViewModel = koinViewModel()) {
    LazyColumn {
        items(fruitViewModel.state.fruits) { fruit ->
            Text("VAISIUS: " + fruit)
            Button(onClick = {
                Toast.makeText(context, fruit, Toast.LENGTH_LONG).show()
            }) {
                Text("Get item")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewList() {
    //FruitsList()
}