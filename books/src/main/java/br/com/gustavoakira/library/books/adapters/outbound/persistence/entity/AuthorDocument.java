package br.com.gustavoakira.library.books.adapters.outbound.persistence.entity;


import br.com.gustavoakira.library.books.application.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDocument {
    @Id
    private String id = ObjectId.get().toHexString();
    private String name;

    public static AuthorDocument fromDomain(Author author){
        return new AuthorDocument(author.getId(),author.getName());
    }

    public Author toDomain() {
        return new Author(this.name,this.id);
    }
}
