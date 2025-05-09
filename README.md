# 🔄📱⌚ WearPhoneChatApp

**Comunicação Bidirecional entre Android e Wear OS via Firebase Firestore**

## 📝 Descrição

Este projeto demonstra a sincronização e troca de mensagens em tempo real entre um smartphone Android e um smartwatch Wear OS utilizando o **Firebase Firestore**. Ambos os dispositivos podem **enviar, receber, armazenar e exibir mensagens**, criando uma experiência de chat simples e eficiente, com persistência na nuvem.

O app é dividido em dois módulos:
- **Smartphone (Android)**: envia e escuta mensagens, exibindo-as em uma interface do tipo chat.
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

1. **Clone este repositório**:
   ```bash
   git clone https://github.com/seu-usuario/WearPhoneChatApp.git
Abra o projeto no Android Studio.

**No Android Studio, acesse:
Tools > Firebase
e conecte os módulos Android e Wear ao seu projeto Firebase.

**Altere os arquivos google-services.json:

**Acesse a console do Firebase.

**Selecione seu projeto e baixe o google-services.json correspondente a cada módulo.

**Envie e receba mensagens entre os dispositivos para testar a comunicação bidirecional.

⚠️ Observações Importantes
🔐 O arquivo google-services.json contém credenciais sensíveis e está vinculado à sua conta do Firebase.

🌐 Certifique-se de que ambos os dispositivos estejam com conexão com a internet, pois o Firestore depende de conexão ativa com a nuvem.

📸 Demonstrações
### 📸 **Smartwatch – Interface com Jetpack Compose
   ![Cel](https://github.com/user-attachments/assets/46b5ef31-2e6e-4690-a550-c74648d06577)

### 📱 **Smartphone – Interface com mensagens
   ![Smart](https://github.com/user-attachments/assets/c01555e0-1843-425d-82e9-9a5381b2d88f)

