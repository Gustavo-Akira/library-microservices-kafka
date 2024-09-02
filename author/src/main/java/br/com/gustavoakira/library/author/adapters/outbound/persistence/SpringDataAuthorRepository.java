package br.com.gustavoakira.library.author.adapters.outbound.persistence;

import br.com.gustavoakira.library.author.adapters.outbound.persistence.entity.AuthorEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface SpringDataAuthorRepository extends R2dbcRepository<AuthorEntity, Long> {
    @Query("Select a from AuthorEntity a")
    Flux<AuthorEntity> findAllBy(Pageable withPage);
    @Query("SELECT a from AuthorEntity a where a.name LIKE '%?0%'")
    Flux<AuthorEntity> findAllByName(String name, Pageable withPage);
}
