    package com.example.atv_jogadores

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
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
    import com.example.atv_jogadores.classes.Jogador

    class MainActivity : ComponentActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
              verJogadores()
            }
        }
    }

    @Composable
    fun verJogadores() {
        // Lista de jogadores, inicializando 6 jogadores com nomes padrão.
        val jogadores = remember { List(6) { Jogador(nome = "Jogador ${it + 1}") } }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(jogadores) { jogador ->
                JogadorDetalhes(jogador)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

@Composable
fun JogadorDetalhes(jogador: Jogador) {
        var level by remember { mutableStateOf(jogador.level) }
        var bonusEquipamento by remember { mutableStateOf(jogador.bonusEquipamento) }
        var modificadores by remember { mutableStateOf(jogador.modificadores) }

        Column(modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            // Campo para editar o nome do jogador.
            TextField(
                value = jogador.nome,
                onValueChange = { jogador.nome = it },
                label = { Text(text = "Nome do Jogador") }
            )

            // Controle para o nível do jogador.
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    if (level > 1) level--
                    jogador.level = level
                }) {
                    Text(text = "-")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(text = "Level: $level", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = {
                    if (level < 10) level++
                    jogador.level = level
                }) {
                    Text(text = "+")
                }
            }


            // Controle para o bônus de equipamento.
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    if (bonusEquipamento > 0) bonusEquipamento--
                    jogador.bonusEquipamento = bonusEquipamento
                }) {
                    Text(text = "-")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(text = "Bônus Equipamento: $bonusEquipamento", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = {
                    if (bonusEquipamento < 40) bonusEquipamento++
                    jogador.bonusEquipamento = bonusEquipamento
                }) {
                    Text(text = "+")
                }
            }

            // Controle para os modificadores.
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    if (modificadores > -5) modificadores--
                    jogador.modificadores = modificadores
                }) {
                    Text(text = "-")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(text = "Modificadores: $modificadores", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = {
                    if (modificadores < 10) modificadores++
                    jogador.modificadores = modificadores
                }) {
                    Text(text = "+")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Poder Total: ${jogador.poderTotal}", textAlign = TextAlign.Center)
            }
        }
}



    @Preview(showBackground = true)
    @Composable
    fun verPreview() {
        // Para visualizar um exemplo, você pode criar um jogador fictício aqui.
        val jogadorExemplo = Jogador(nome = "Jogador Exemplo")
        JogadorDetalhes(jogadorExemplo)
    }