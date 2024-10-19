package michael.koers.spring_ai_demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findBookByAuthor(String name);

    Book findBookById(long id);
}
