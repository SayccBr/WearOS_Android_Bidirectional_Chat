package com.example.wearphonebidirecionalchat.model

data class Mensagem(
    val usuario: String = "",
    val conteudo: String = "",
    val timestamp: Long = System.currentTimeMillis() // adiciona timestamp
)

