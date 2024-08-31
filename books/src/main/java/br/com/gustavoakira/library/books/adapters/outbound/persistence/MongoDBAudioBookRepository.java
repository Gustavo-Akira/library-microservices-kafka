package br.com.gustavoakira.library.books.adapters.outbound.persistence;

import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.AudioBookDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBAudioBookRepository extends ReactiveMongoRepository<AudioBookDocument,String> {
}
