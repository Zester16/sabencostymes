package com.example.sabencostimes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.navigation.NavGraph

import com.example.sabencostimes.ui.theme.SabencosTimes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SabencosTimes {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    val navController = rememberNavController()
                    Column() {
                        Greeting("Business")
                        NavGraph(navController = navController)
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {






}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SabencosTimes {
        Greeting("Android")
    }
}