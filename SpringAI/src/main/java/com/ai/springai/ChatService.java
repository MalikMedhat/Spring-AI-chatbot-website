package com.ai.springai;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatModel chatModel;

    public String chat(String userMessage) {
        try {
            return chatModel.call(new Prompt(userMessage))
                    .getResult()
                    .getOutput()
                    .getContent();
        } catch (Exception e) {
            return "Error: " + e.getMessage() + ". Make sure Ollama is running on port 11434.";
        }
    }
}
