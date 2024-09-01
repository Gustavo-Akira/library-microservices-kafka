package br.com.gustavoakira.library.books.adapters.outbound.persistence.entity;

import br.com.gustavoakira.library.books.application.domain.Book;
import br.com.gustavoakira.library.books.application.domain.EBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "bookData")
@TypeAlias("EBookData")
@NoArgsConstructor
public class EBookDocument extends BookDocument{
    private Integer pages;
    private String downloadUrl;
    private Double fileSize;

    public EBookDocument(String id, List<AuthorDocument> author, String name, LocalDate publicationDate, Double price, Integer pages, String downloadUrl, Double fileSize) {
        super(id, author, name, publicationDate, price);
        this.pages = pages;
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    @Override
    public Book toDomain() {
        return new EBook(getId(),getAuthor().stream().map(AuthorDocument::toDomain).toList(),getName(),getPublicationDate(),getPrice(),getPages(),getDownloadUrl(),getFileSize());
    }


    public static EBookDocument fromDomain(EBook book) {
        return new EBookDocument(book.getId(),book.getAuthor().stream().map(AuthorDocument::fromDomain).toList(), book.getName(), book.getPublicationDate(),book.getPrice(), book.getPages(), book.getDownloadUrl(), book.getFileSize());
    }
}
