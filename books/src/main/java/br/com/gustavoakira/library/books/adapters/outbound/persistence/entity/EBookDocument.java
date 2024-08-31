package br.com.gustavoakira.library.books.adapters.outbound.persistence.entity;

import br.com.gustavoakira.library.books.application.domain.Book;
import br.com.gustavoakira.library.books.application.domain.EBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bookData")
@TypeAlias("EBookData")
@AllArgsConstructor
@NoArgsConstructor
public class EBookDocument extends BookDocument{
    private Integer pages;
    private String downloadUrl;
    private Double fileSize;

    @Override
    public Book toDomain() {
        return null;
    }


    public static EBookDocument fromDomain(EBook book) {
        return null;
    }
}
