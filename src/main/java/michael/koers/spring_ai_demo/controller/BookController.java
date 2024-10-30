package michael.koers.spring_ai_demo.controller;

import michael.koers.spring_ai_demo.repository.BookRepository;
import michael.koers.spring_ai_demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public String index() {
        return """
                /book/{id}
                /author/{name}
                """;
    }

    @GetMapping("/book/{id}")
    public Book author(@PathVariable Long id) {
        return bookRepository.findBookById(id);
    }

    @GetMapping("/author/{name}")
    public List<Book> authors(@PathVariable String name) {
        return bookRepository.findBookByAuthor(name);
    }
}
