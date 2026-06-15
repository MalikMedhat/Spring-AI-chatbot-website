package com.ai.springai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ai.chat.model.ChatModel; // الـ Import المعياري الجديد
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatModel chatModel; // الجافا هيلقط لوحده إن ده Groq من الـ properties

    public String chat(String prompt) {
        try {
            return chatModel.call(prompt); // استدعاء الموديل
        } catch (Exception e) {
            return "Error calling Groq API: " + e.getMessage();
        }
    }
}
