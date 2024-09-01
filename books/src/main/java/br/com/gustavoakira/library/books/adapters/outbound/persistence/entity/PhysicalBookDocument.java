package br.com.gustavoakira.library.books.adapters.outbound.persistence.entity;

import br.com.gustavoakira.library.books.application.domain.Book;
import br.com.gustavoakira.library.books.application.domain.PhysicalBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PhysicalBookDocument extends BookDocument{
    private String isbn;
    private Integer pages;
    private Integer quantity;



    public PhysicalBookDocument(String id, List<AuthorDocument> author, String name, LocalDate publicationDate, Double price, String isbn, Integer pages, Integer quantity) {
        super(id, author, name, publicationDate, price);
        this.isbn = isbn;
        this.pages = pages;
        this.quantity = quantity;
    }

    @Override
    public Book toDomain() {
        return new PhysicalBook(getId(),getAuthor().stream().map(AuthorDocument::toDomain).toList(),getName(),getPublicationDate(),getPrice(),isbn,pages,quantity);
    }

    public static PhysicalBookDocument fromDomain(PhysicalBook physicalBook) {
        return new PhysicalBookDocument(physicalBook.getId(),physicalBook.getAuthor().stream().map(AuthorDocument::fromDomain).toList(),physicalBook.getName(),physicalBook.getPublicationDate(),physicalBook.getPrice(),physicalBook.getIsbn(),physicalBook.getPages(), physicalBook.getQuantity());
    }
}
