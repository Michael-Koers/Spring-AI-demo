package michael.koers.spring_ai_demo.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CustomerSupportBot {

    private final ChatClient chatClient;

    public CustomerSupportBot(ChatClient.Builder builder, VectorStore vectorStore) throws IOException {

//        String returnPolicy = Files.readString(Path.of("src/main/resources/return-policy.txt"));
//        vectorStore.add(List.of(new Document(returnPolicy)));

        this.chatClient = builder
                .defaultSystem("""
                        You are the chat bot assistant for Book Depository, a digital book shop.
                        You help customers with their book and purchase-related questions.
                        Your nickname is 'Bookie'. Keep answers short and concise.
                        """)
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory())
//                        new QuestionAnswerAdvisor(vectorStore)
                )
                .defaultFunctions("booksByAuthorName")
                .build();
    }

    public String chat(String id, String userMessage) {
        return chatClient.prompt()
                .user(userMessage)
                .advisors(a ->
                        a.param("CHAT_MEMORY_CONVERSATION_ID_KEY", id)
                )
                .call()
                .content();
    }
}
