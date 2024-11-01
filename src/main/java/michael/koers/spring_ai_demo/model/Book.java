package michael.koers.spring_ai_demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100)
    String author;

    @Column(length = 100)
    String title;

    @Column
    double price;

}
