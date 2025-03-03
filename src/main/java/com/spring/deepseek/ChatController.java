package com.spring.deepseek;

import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final OllamaChatModel chatModel;

    @Autowired
    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate")
    public Map<String, String> generate (@RequestParam(value = "message", defaultValue =  "tell me about yourself")){
        return Map.of("generation", this.chatModel.call(message));
    }

    public  Flux<ChatResponse> generateStream(@RequestParam(value="message", defaultValue= "tell me about yourself")){
        Prompt prompt  = new Prompt(new UserMessage(message));
        return this.chatModel.stream(prompt);
    }
}