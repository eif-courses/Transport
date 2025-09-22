package lt.viko.eif.transport.appsas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel


@Composable
fun FruitsList(fruitViewModel: FruitViewModel = koinViewModel()) {
    LazyColumn {
        items(fruitViewModel.state.fruits) { fruit ->
            Text("VAISIUS: " + fruit)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewList() {
    FruitsList()
}