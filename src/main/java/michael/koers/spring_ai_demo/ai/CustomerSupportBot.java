package michael.koers.spring_ai_demo.ai;

import michael.koers.spring_ai_demo.model.Chat;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CustomerSupportBot {

    private final ChatClient chatClient;

    public CustomerSupportBot(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                        You are the chat bot assistant for Book Depository, a digital book shop.
                        You help customers with their book and purchase-related questions.
                        Your nickname is 'Bookie'.
                        Keep answers short and concise, only answer Book Depository related questions.
                        """)
                .build();
    }

    public Chat chat(String userMessage) {
        return new Chat("AI", this.chatClient.prompt()
                .user(userMessage)
                .call()
                .content());
    }
}
