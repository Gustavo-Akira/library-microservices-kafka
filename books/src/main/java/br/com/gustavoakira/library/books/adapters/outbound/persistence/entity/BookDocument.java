package br.com.gustavoakira.library.books.adapters.outbound.persistence.entity;

import br.com.gustavoakira.library.books.application.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BookDocument {
    @Id
    private String id;
    private List<AuthorDocument> author;
    private String name;
    private LocalDate publicationDate;
    private Double price;

    public abstract Book toDomain();

}
