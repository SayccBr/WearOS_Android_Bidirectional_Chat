package com.example.wear.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.wear.presentation.model.Mensagem
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o Firebase
        FirebaseApp.initializeApp(this)

        // Define o conteúdo da tela usando Compose
        setContent {
            ChatWearOS()
        }
    }
}

@Composable
fun ChatWearOS() {
    val db = FirebaseFirestore.getInstance()

    // Lista de mensagens exibidas no chat
    var mensagens by remember { mutableStateOf(listOf<Mensagem>()) }

    // Campo de texto para digitar mensagem
    var textoDigitado by remember { mutableStateOf(TextFieldValue()) }

    // Escutar atualizações em tempo real do Firestore
    LaunchedEffect(Unit) {
        db.collection("mensagens").addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                val lista = snapshot.toObjects(Mensagem::class.java)
                mensagens = lista.sortedBy { it.timestamp }
            }
        }
    }


    // Layout da tela
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Lista de mensagens com rolagem
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            mensagens.forEach { msg ->
                Text("${msg.usuario}: ${msg.conteudo}")
            }
        }

        // Campo de texto para digitar
        TextField(
            value = textoDigitado,
            onValueChange = { textoDigitado = it },
            label = { Text("Mensagem") }
        )

        // Botão para enviar a mensagem
        Button(onClick = {
            val texto = textoDigitado.text
            if (texto.isNotBlank()) {
                val mensagem = Mensagem("WearOS", texto)
                db.collection("mensagens").add(mensagem)
                textoDigitado = TextFieldValue()
            }
        }) {
            Text("Enviar")
        }
    }
}
