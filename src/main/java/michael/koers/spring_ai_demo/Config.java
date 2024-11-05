package michael.koers.spring_ai_demo;

import michael.koers.spring_ai_demo.repository.BookFunction;
import michael.koers.spring_ai_demo.repository.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class Config {

    @Bean
    @Description("Gets a list of available books by author name at BookDepository")
    public Function<BookFunction.Request, BookFunction.Response> booksByAuthorName(BookRepository bookRepository){
        return new BookFunction(bookRepository);
    }
}
