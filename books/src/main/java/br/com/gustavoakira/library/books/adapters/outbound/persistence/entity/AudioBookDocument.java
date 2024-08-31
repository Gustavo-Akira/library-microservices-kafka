package br.com.gustavoakira.library.books.adapters.outbound.persistence.entity;

import br.com.gustavoakira.library.books.application.domain.AudioBook;
import br.com.gustavoakira.library.books.application.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bookData")
@TypeAlias("AudioBookData")
@AllArgsConstructor
@NoArgsConstructor
public class AudioBookDocument extends BookDocument{
    private String narrator;
    private Double duration;

    @Override
    public Book toDomain() {
        return new AudioBook(this.getId(),getAuthor().stream().map(AuthorDocument::toDomain).toList(),getName(),getPublicationDate(),getPrice(),getNarrator(),getDuration());
    }


    public static AudioBookDocument fromDomain(AudioBook book) {
        return new AudioBookDocument();
    }
}
