package michael.koers.spring_ai_demo.repository;

import lombok.extern.java.Log;
import michael.koers.spring_ai_demo.model.Book;

import java.util.List;
import java.util.function.Function;

@Log
public class BookFunction implements Function<BookFunction.Request, BookFunction.Response> {

    private final BookRepository bookRepository;

    public BookFunction(BookRepository bookRepository) {
        log.info("LLM was here!");
        this.bookRepository = bookRepository;
    }

    public Response apply(Request request) {
        return new Response(bookRepository.findBookByAuthor(request.author));
    }

    public record Request(String author) {
    }

    public record Response(List<Book> books) {
    }
}
