package com.example.captaingame

import android.content.Context
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame(){
    // Inside an Activity
    val context = LocalContext.current
    val treasureFound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val hp = remember{ mutableStateOf(1000) }
    val sailingStatus = remember{ mutableStateOf("Sailing peacefully") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Treasures Found: ${treasureFound.value}")
        Text(text = "Treasures Found: ${direction.value}")
        Text(text = "${sailingStatus.value} in ${direction.value} your ship remaining HP is : ${hp.value}")
        if (hp.value == 0) {
            LaunchedEffect(key1 = hp.value) {
                Toast.makeText(context, "Game Over! Your HP is zero.", Toast.LENGTH_LONG).show()
            }
        }

        val buttonsEnabled = hp.value > 0

            Button(onClick = {
                direction.value = "East"
                if (Random.nextBoolean()) {
                    treasureFound.value += 1
                    sailingStatus.value
                } else {
                    hp.value -= 100
                    sailingStatus.value = "A storm encountered"
                }
            },
                enabled = buttonsEnabled
                ) {
                Text("Sail East")
            }

            Button(onClick = {
                direction.value = "West"
                if (Random.nextBoolean()) {
                    treasureFound.value += 1
                    sailingStatus.value
                } else {
                    hp.value -= 100
                    sailingStatus.value = "A storm encountered"
                }
            },
                enabled = buttonsEnabled
                ) {
                Text("Sail West")
            }

            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()) {
                    treasureFound.value += 1
                    sailingStatus.value
                } else {
                    hp.value -= 100
                    sailingStatus.value = "A storm encountered"
                }
            },
                enabled = buttonsEnabled
                ) {
                Text("Sail North")
            }

            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasureFound.value += 1
                    sailingStatus.value
                } else {
                    hp.value -= 100
                    sailingStatus.value = "A storm encountered"
                }
            },
                enabled = buttonsEnabled
                ) {
                Text("Sail South")
            }
        }
}





@Preview(showBackground = true)
@Composable
fun CaptainGamePreview() {
    CaptainGameTheme {
        CaptainGame()
    }
}