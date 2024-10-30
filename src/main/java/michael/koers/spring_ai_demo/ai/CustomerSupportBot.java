//package michael.koers.spring_ai_demo.ai;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.function.ServerResponse;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Service
//public class CustomerSupportBot {
//
//    private final ChatClient chatClient;
//
//    public CustomerSupportBot(ChatClient.Builder builder) {
//        this.chatClient = builder
//                .build();
//    }
//
//    public Flux<String> chatStream(String chatId, String userMessage) {
//        return this.chatClient.prompt()
//                .user(userMessage)
//                .stream()
//                .content();
//    }
//}
