package michael.koers.spring_ai_demo;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller("")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    private static final List<Chat> chatHistory = new ArrayList<>();

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("chatHistory", chatHistory);
        model.addAttribute("chat", new Chat());
        return "index";
    }

    @PostMapping("/chat")
    public String chat(@ModelAttribute Chat chat, Model model) {
        chat.setSender("user");
        chatHistory.add(chat);

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("chatHistory", chatHistory);

        return "index";
    }
}
