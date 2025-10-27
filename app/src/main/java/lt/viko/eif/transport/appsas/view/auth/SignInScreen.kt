package lt.viko.eif.transport.appsas.view.auth


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    viewModel: AuthViewModel = koinViewModel()
){

    Column {
        Row {
            Button(onClick = {
                viewModel.signIn("petras@gmail.com","Kolegija1@")
            }){
                Text("Sing In")
            }

            Text("res: "+viewModel.uiState.token)
        }


    }



}