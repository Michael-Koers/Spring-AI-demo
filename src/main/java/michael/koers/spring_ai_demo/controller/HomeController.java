package michael.koers.spring_ai_demo.controller;

import michael.koers.spring_ai_demo.ai.CustomerSupportBot;
import michael.koers.spring_ai_demo.model.Chat;
import michael.koers.spring_ai_demo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final List<Chat> history = new ArrayList<>();

    private final BookRepository bookRepository;
    private final CustomerSupportBot bot;

    public HomeController(BookRepository bookRepository, CustomerSupportBot bot) {
        this.bookRepository = bookRepository;
        this.bot = bot;
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("chat", new Chat());
        model.addAttribute("history", history);
        return "index";
    }

    @PostMapping("/chat")
    public String chat(@ModelAttribute Chat chat, Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("chat", new Chat());

        history.add(chat);
        String id = chat.getMessage().split(":")[0];
        history.add(new Chat("AI", bot.chat(id, chat.getMessage())));
        model.addAttribute("history", history);

        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("chat", new Chat());

        history.clear();
        model.addAttribute("history", history);

        return "redirect:/";
    }
}
