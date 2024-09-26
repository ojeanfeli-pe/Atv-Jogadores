package com.example.atv_jogadores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          verJogador()
        }
    }
}

@Composable
fun verJogador(){

    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextField(value = name, onValueChange ={name = it},
            label = { Text(text = "Nome do Jogador")})

        Jogador()
    }

}

@Composable
fun Jogador(){

    var level by remember {
        mutableStateOf(0)
    }

    Row(modifier = Modifier.fillMaxWidth().padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            if (level > 0) {
                level -= 1
            }
        }) {
            Text(text = "-")
        }

        Text(text = "Level: $level",
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Button(onClick = {
            if (level < 10) {
                level += 1
            }
        }) {
            Text(text = "+")
        }

    }

    var equipament by remember {
        mutableStateOf(0)
    }

    Row(modifier = Modifier.fillMaxWidth().padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            if (equipament > 0 ){
                equipament -= 1
            }
        }) {
            Text(text = "-")
        }

        Text(text = "Equipamento: $equipament",
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Center)

        Button(onClick = {
            if (equipament < 40){
                equipament += 1
            }
        }) {
            Text(text = "+")
        }

    }

    var maldicoes by remember {
        mutableStateOf(0)
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            if (maldicoes > -5) {
                maldicoes -= 1
            }
        }) {
            Text(text = "-")
        }

        Text(
            text = "Modif: $maldicoes",
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Button(onClick = {
            if (maldicoes < 10) {
                maldicoes += 1
            }
        }) {
            Text(text = "+")
        }

    }

    var poder by remember {
        mutableStateOf(0)
    }

    poder = level + equipament + maldicoes

    Text(text = "Poder: $poder")
}


@Preview(showBackground = true)
@Composable
fun verPreview(){
    Jogador()
}