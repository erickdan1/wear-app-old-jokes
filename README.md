Um aplicativo simples para dispositivos **Wear OS** que exibe piadas retiradas de uma API externa. Este projeto utiliza conexão HTTP para buscar as piadas, permitindo que você leve um pouco de humor ao seu pulso!   

---

## 🚀 Funcionalidades  

- **Conexão com API Externa:** Consome piadas da API [icanhazdadjoke](https://icanhazdadjoke.com/).  
- **Interface Simples e Intuitiva:** Um botão para carregar novas piadas e uma área de exibição.  
- **Compatível com Wear OS:** Design otimizado para smartwatches.  
- **Mensagens de Erro Amigáveis:** Feedback caso ocorra algum problema de conexão.  

---

## 🛠️ Tecnologias Utilizadas  

- **Linguagem:** Kotlin  
- **API HTTP:** Retrofit  
- **Coroutines:** Para gerenciar chamadas assíncronas à API.  
- **Wear OS SDK:** Para desenvolvimento de aplicativos otimizados para dispositivos vestíveis.  

---

## 🌐 Como Funciona  

1. **Tela Inicial:** O app exibe uma tela com:  
   - Um botão para buscar novas piadas.  
   - Uma área de texto para exibir a piada recebida da API.  

2. **Conexão com a API:**  
   - O app utiliza **Retrofit** para realizar chamadas HTTP GET à URL base `https://icanhazdadjoke.com/`.  
   - A resposta é convertida em um modelo Kotlin e exibida no app.  

3. **Gerenciamento de Erros:**  
   - Caso ocorra um erro na conexão, o app exibe a mensagem: *"Sorry, no more jokes for you"*.  

---

## 📋 Requisitos  

- **Android Studio** 
- **SDK Wear OS**   
- **Dispositivo ou emulador Wear OS**  
- **Conexão com a internet**  

---

## 📦 Instalação  

Siga os passos abaixo para configurar e executar o projeto localmente:  

1. **Clone o repositório:**  
   ```bash  
   git clone https://github.com/seu-usuario/joke-wear-app.git  
   cd jokewear  
   ```  

2. **Abra o projeto no Android Studio:**  
   Certifique-se de ter o **Android Studio Bumblebee** ou superior instalado.  

3. **Configuração do ambiente:**  
   - Conecte um emulador ou dispositivo Wear OS.  
   - Configure uma conexão com a internet para o emulador.  

4. **Execute o aplicativo:**  
   - Clique no botão "Run" no Android Studio para instalar o app no dispositivo Wear OS.  

---

## Demonstração

https://github.com/user-attachments/assets/a42c9df9-c7cd-4eeb-8255-acd625001c08


Divirta-se com as piadas! 😄
