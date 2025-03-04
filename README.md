# DeepSeek API

DeepSeek API is a Spring Boot-based AI chatbot service powered by OllamaChatModel. This project provides RESTful endpoints for AI-generated text responses, with both standard and streaming responses.

## Features

- AI-powered text generation using OllamaChatModel.
- Supports synchronous and streaming responses.
- Built with Spring Boot for easy deployment and scalability.

## Installation

### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven
- Ollama AI Model

### Clone the Repository
```sh
git clone https://github.com/khan7071/DEEPSEEK.git
cd DEEPSEEK
```

### Build and Run
To build and run the application, use:
```sh
mvn clean install
mvn spring-boot:run
```

The application will start on http://localhost:8080.

## API Endpoints

### Generate AI Response
Endpoint:
```http
GET /ai/generate?message={your_message}
```
Example:
```sh
curl "http://localhost:8080/ai/generate?message=Tell+me+a+joke"
```
Response:
```json
{
  "generation": "Why don’t scientists trust atoms? Because they make up everything!"
}
```

### Generate AI Response Stream
Endpoint:
```http
GET /ai/generateStream?message={your_message}
```
Example:
```sh
curl "http://localhost:8080/ai/generateStream?message=Tell+me+a+joke"
```
Response (Streamed JSON objects):
```json
{
  "response": "Sure, here's a joke..."
}
```

## Configuration
The application can be configured using `application.properties`:
```properties
spring.application.name=deepseek
spring.ai.ollama.chat.options.model=deepseek-r1:1.5b
```

## Technologies Used
- Java 17
- Spring Boot
- Spring AI
- Reactor (Flux for Streaming Responses)

## Contributing
Feel free to submit issues and pull requests! Contributions are welcome.
