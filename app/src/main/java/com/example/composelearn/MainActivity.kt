package com.example.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.local.ksp.api.ProvidedComposeLocal
import com.example.composelearn.ui.theme.ComposeLearnTheme

class MainActivity : ComponentActivity() {

    @ProvidedComposeLocal
    val viewModel: MainViewModel = MainViewModel()

    @ProvidedComposeLocal
    val viewModel2: MainViewModel2 = MainViewModel2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                MainActivityComposeLocalProvider {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainViewModel = viewModel()) {

    Button(modifier = Modifier.layoutId(3123), onClick = {

    }) {
        Text(text = "Hello ${viewModel.name}!")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearnTheme {
        Greeting()
    }
}