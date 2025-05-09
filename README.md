# 🔄📱⌚ WearPhoneChatApp

**Comunicação Bidirecional entre Android e Wear OS via Firebase Firestore**

## 📝 Descrição

Este projeto demonstra a sincronização e troca de mensagens em tempo real entre um smartphone Android e um smartwatch Wear OS utilizando o **Firebase Firestore**. Ambos os dispositivos podem **enviar, receber, armazenar e exibir mensagens**, criando uma experiência de chat simples e eficiente, com persistência na nuvem.

O app é dividido em dois módulos:
- **Smartphone (Android)**: envia e escuta mensagens, exibindo em uma interface do tipo chat.
- **Smartwatch (Wear OS)**: possui interface simplificada em **Jetpack Compose** para envio e visualização de mensagens.

## 🚀 Funcionalidades

- ✅ Envio de mensagens do smartphone para o Firebase.
- ✅ Envio de mensagens do smartwatch para o Firebase.
- 🔄 Atualização automática da interface ao receber novas mensagens (snapshot listener).
- ☁️ Persistência dos dados na nuvem com Firebase Firestore.
- 🖼️ Interface simples, responsiva e leve para ambos os dispositivos.

## 🛠️ Tecnologias Utilizadas

- **Kotlin** – Linguagem principal dos módulos Wear OS e Android.
- **Firebase Firestore** – Banco de dados em nuvem para persistência e sincronização em tempo real.
- **Jetpack Compose** – UI declarativa no smartwatch (Wear OS).
- **Material 3** – Componentes modernos para a interface.
- **Android Studio Iguana / Meerkat** – IDE utilizada no desenvolvimento.

## 🏁 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/WearPhoneChatApp.git
