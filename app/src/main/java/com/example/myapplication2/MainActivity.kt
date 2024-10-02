package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication2.ui.theme.MyApplication2Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            //image1();
            //image2();
            ImageComposable();
        }
    }
}

@Composable
fun Greeting(name: String = "elyes", modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.background(Color.Green)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication2Theme {
        Greeting("Za9ala")
    }
}


@Composable
fun image1() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Bloc rouge
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red)
        )
        Row(
            modifier = Modifier.weight(1f)
        ) {
            // Bloc bleu à gauche
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue)
            )
            // Bloc vert à droite
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green)
            )
        }
    }
}

@Composable
fun image2() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            // Bloc bleu en haut à gauche
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue)
            )
            // Bloc vert en haut à droite
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            // Bloc rouge en bas à gauche
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            // Bloc jaune en bas à droite
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
            )
        }
    }
}



@Composable
fun ImageComposable(modifier: Modifier = Modifier) {
    // Correction de la syntaxe : mutableStateOf
    var res by remember {
        mutableStateOf(R.drawable.kermit)
    }

    // Utilisation correcte de `Column`
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,  // Correction des fautes de frappe
        verticalArrangement = Arrangement.Center
    ) {
        // Image avec `painterResource` et `contentScale`
        Image(
            painter = painterResource(id = res),
            contentDescription = "test image",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Fit  // Correction de la syntaxe
        )

        // TextButton correctement structuré
        TextButton(
            onClick = {
                res = R.drawable.kermit_screaming  // Correction du nom de la ressource
            }
        ) {
            Text(text = "Click me")
        }
    }
}