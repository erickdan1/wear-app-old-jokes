/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.someoldjokes.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.someoldjokes.R
import com.example.someoldjokes.presentation.theme.SomeOldJokesTheme

class MainActivity : ComponentActivity() {

    private val jokes: List<String> = listOf("O que acontece quando chove na Inglaterra?\n" + "- Vira Inglalama",
        "O que o tomate foi fazer no banco?\n" + "- Tirar extrato",
        "Um caipira chega a casa de um amigo que está vendo TV e pergunta:\n" + "- E aí, firme?\n" + "- Não, futebor")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        // Set the content of the activity to the layout file
        setContentView(R.layout.activity_main)

        // Initialize views
        var modifiedTextView = findViewById<TextView>(R.id.jokeTextView)

        // Set a click listener for the button
        var jokeButton = findViewById<TextView>(R.id.jokeButton)
        jokeButton.setOnClickListener {
            // Randomly select an element from the list
            val elementoAleatorio = jokes.random()
            modifiedTextView.text = elementoAleatorio
        }
    }
}

/*
@Composable
fun WearApp(greetingName: String) {
    SomeOldJokesTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            TimeText()
            Greeting(greetingName = greetingName)
        }
    }
}

@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.hello_world, greetingName)
    )
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}
 */