package br.com.gustavoakira.library.author.adapters.outbound.persistence.entity;

import br.com.gustavoakira.library.author.application.domain.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String biography;
    public static AuthorEntity fromDomain(Author author){
        return new AuthorEntity(author.getId(), author.getName(),author.getBiography());
    }

    public Author toDomain() {
        return new Author(id,name,biography);
    }
}
