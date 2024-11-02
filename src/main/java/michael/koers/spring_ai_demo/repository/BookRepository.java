package michael.koers.spring_ai_demo.repository;

import michael.koers.spring_ai_demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookRepository extends CrudRepository<Book, Long>  {

    List<Book> findBookByAuthor(String name);

    Book findBookById(long id);
}
