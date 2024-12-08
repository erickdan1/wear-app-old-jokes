/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.someoldjokes.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.someoldjokes.presentation.controller.JokeController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    val BASE_URL: String = "https://icanhazdadjoke.com"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        // Set the content of the activity to the layout file
        setContentView(R.layout.activity_main)

        // Build a Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL) // Set the base URL for all API calls
            .addConverterFactory(GsonConverterFactory.create()) // Add a converter for JSON responses
            .build()

        // Initialize views
        var modifiedTextView = findViewById<TextView>(R.id.jokeTextView)

        // Create an instance of the JokeController interface
        val jokeController = retrofit.create(JokeController::class.java)

        // Find the button with the ID "jokeButton" from your layout
        val jokeButton = findViewById<Button>(R.id.jokeButton)
        // Set a click listener for the button
        jokeButton.setOnClickListener {
            // Create a coroutine scope using Dispatchers.IO for network operations
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    // Call the getJoke() method of the JokeController interface
                    val joke = jokeController.getJoke() // This will be a suspend function

                    // Switch to the Main thread to update the UI
                    withContext(Dispatchers.Main) {
                        // Assuming modifiedTextView is where you want to display the joke
                        modifiedTextView.text = joke.joke // Update the text with the joke content (assuming joke.joke is the property holding the joke text)
                    }
                } catch (e: Exception) {
                    // Switch to the Main thread to update the UI in case of error
                    withContext(Dispatchers.Main) {
                        modifiedTextView.text = "Sorry, no more jokes for you" // Display an error message
                    }
                }
            }
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