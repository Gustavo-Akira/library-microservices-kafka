package br.com.gustavoakira.library.books.adapters.outbound.persistence;

import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.BookDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoDBBookRepository extends ReactiveMongoRepository<BookDocument, String> {
}
