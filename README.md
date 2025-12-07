# WeatherViewer: Aplicativo de Previsão do Tempo

## 📄 Informações do Projeto

| Campo | Detalhe |
| :--- | :--- |
| **Aluno(a)** | Ana Flavia Alves Rosa |
| **Curso** | Sistemas de Informação |
| **Período** | 6º Período |
| **Disciplina** | Programação III |
| **Professor** | Eduardo Henrique Marques Ferreira |
| **Livro Base** | Android 6 for Programmers: An App-Driven Approach (Deitel) |

## 💡 Descrição da Aplicação

O **WeatherViewer** é um aplicativo móvel desenvolvido em **Java** para a plataforma **Android**, criado como parte da Atividade Prática Individual da disciplina de Programação III.

O objetivo principal do aplicativo é consumir um **Web Service REST** de previsão do tempo, processar os dados retornados em formato **JSON** e exibi-los em uma lista personalizada para o usuário. O projeto segue a estrutura e o fluxo de chamadas do Capítulo 7 – *WeatherViewer App* do livro-texto da disciplina, adaptado para consumir uma API específica fornecida pelo professor.

### Funcionalidades Principais

*   **Entrada de Cidade:** Permite ao usuário inserir o nome da cidade para consulta.
*   **Requisição Assíncrona:** Realiza a requisição HTTP em uma *AsyncTask* separada para evitar o bloqueio da *thread* principal (UI).
*   **Processamento JSON:** Analisa a resposta JSON do serviço, extraindo informações como data, temperaturas mínima e máxima, umidade, descrição e ícone (emoji).
*   **Exibição em Lista:** Apresenta a previsão do tempo para os próximos 7 dias em uma lista (*ListView*) com um adaptador personalizado (*WeatherArrayAdapter*).
*   **Tratamento de Erros:** Inclui tratamento básico para erros de rede e requisição.

## 🛠️ Tecnologias Utilizadas

*   **Linguagem:** Java
*   **Plataforma:** Android (Desenvolvido no Android Studio)
*   **Comunicação:** HTTPURLConnection para requisições REST
*   **Estrutura de Dados:** JSON

## ⚙️ Instruções para Execução

Para executar o projeto **WeatherViewer**, siga os passos abaixo:

1.  **Pré-requisitos:**
    *   Ter o **Android Studio** instalado.
    *   Ter um dispositivo Android (físico ou emulador) configurado.

2.  **Clonar o Repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    ```

3.  **Abrir no Android Studio:**
    *   Abra o Android Studio.
    *   Selecione **File > Open** e navegue até o diretório `WeatherViewer`.

4.  **Sincronizar o Projeto:**
    *   Aguarde o Android Studio sincronizar o projeto com o Gradle.

5.  **Executar a Aplicação:**
    *   Selecione o dispositivo de destino (emulador ou físico).
    *   Clique no botão **Run** (ícone de *play* verde) para compilar e instalar o aplicativo.

## 🌐 Detalhes da API

O aplicativo consome a API de previsão do tempo fornecida para a disciplina.

### Exemplo de URL de Requisição

A URL é construída dinamicamente no método `createURL` da `MainActivity.java`, utilizando a cidade fornecida pelo usuário.

**Estrutura da URL:**
```
[ENDPOINT_BASE]/api/weather?city=[CIDADE_ENCODED]&days=7&APPID=[CHAVE_API]
```

**Exemplo de URL (para a cidade "Passos,MG,BR"):**
```
http://agent-weathermap-env-env.eba-6pzgqekp.us-east-2.elasticbeanstalk.com/api/weather?city=Passos%2CMG%2CBR&days=7&APPID=AgentWeather2024_a8f3b9c1d7e2f5g6h4i9j0k1l2m3n4o5p6
```
