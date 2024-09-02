package br.com.gustavoakira.library.author.adapters.outbound.persistence;

import br.com.gustavoakira.library.author.adapters.outbound.persistence.entity.AuthorEntity;
import br.com.gustavoakira.library.author.application.domain.Author;
import br.com.gustavoakira.library.author.application.ports.AuthorRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository

public class AuthorRepositoryPortImpl implements AuthorRepositoryPort {

    private final SpringDataAuthorRepository repository;
    @Autowired
    public AuthorRepositoryPortImpl(SpringDataAuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Author> saveAuthor(Author author) {
        return repository.save(AuthorEntity.fromDomain(author)).map(AuthorEntity::toDomain);
    }

    @Override
    public Flux<Author> findAuthorsByName(String name, Integer page) {
        return repository.findAllByName(name,Pageable.ofSize(5).withPage(page)).map(AuthorEntity::toDomain);
    }

    @Override
    public Mono<Author> findAuthorById(Long id) {
        return repository.findById(id).map(AuthorEntity::toDomain);
    }

    @Override
    public Flux<Author> findAuthors(Integer page) {
        return repository.findAllBy(Pageable.ofSize(5).withPage(page)).map(AuthorEntity::toDomain);
    }

    @Override
    public Mono<Boolean> deleteAuthor(Long id) {
        return repository.deleteById(id).thenReturn(true);
    }

}
