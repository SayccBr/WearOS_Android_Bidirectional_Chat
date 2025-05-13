package com.example.wearphonebidirecionalchat

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.example.wearphonebidirecionalchat.model.Mensagem

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMessages: TextView
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: Button

    private lateinit var db: FirebaseFirestore
    private var listener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicia Firebase
        FirebaseApp.initializeApp(this)

        // Usa o layout XML
        setContentView(R.layout.activity_main)

        // Conecta os elementos da tela
        textViewMessages = findViewById(R.id.textViewMessages)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSend = findViewById(R.id.buttonSend)

        // Inicializa o Firestore
        db = FirebaseFirestore.getInstance()

        // Quando clicar no botão "Enviar"
        buttonSend.setOnClickListener {
            val texto = editTextMessage.text.toString()

            if (texto.isNotEmpty()) {
                val mensagem = Mensagem("Smartphone", texto)
                db.collection("mensagens").add(mensagem)
                editTextMessage.text.clear()
            } else {
                Toast.makeText(this, "Digite uma mensagem", Toast.LENGTH_SHORT).show()
            }
        }

        // Escuta mensagens em tempo real
        listener = db.collection("mensagens")
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null) return@addSnapshotListener

                // Converte os documentos em objetos Mensagem
                val mensagens = snapshot.toObjects(Mensagem::class.java)
                    .sortedBy { it.timestamp } // ordena por timestamp

                // Mostra as mensagens no TextView
                textViewMessages.text = mensagens.joinToString("\n") {
                    "${it.usuario}: ${it.conteudo}"
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        listener?.remove() // Para de escutar quando a tela for destruída
    }
}
