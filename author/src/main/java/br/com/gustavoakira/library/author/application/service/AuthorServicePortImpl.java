package br.com.gustavoakira.library.author.application.service;

import br.com.gustavoakira.library.author.application.domain.Author;
import br.com.gustavoakira.library.author.application.ports.AuthorRepositoryPort;
import br.com.gustavoakira.library.author.application.ports.AuthorServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class AuthorServicePortImpl implements AuthorServicePort {

    @Autowired
    private AuthorRepositoryPort repositoryPort;

    @Override
    public Mono<Author> saveAuthor(Author author) {
        return repositoryPort.saveAuthor(author);
    }

    @Override
    public Flux<Author> findAuthorsByName(String name, Integer page) {
        return repositoryPort.findAuthorsByName(name,page);
    }

    @Override
    public Mono<Author> findAuthorById(Long id) {
        return repositoryPort.findAuthorById(id);
    }

    @Override
    public Flux<Author> findAuthors(Integer page) {
        return repositoryPort.findAuthors(page);
    }

    @Override
    public Mono<Boolean> deleteAuthor(Long id) {
        return repositoryPort.deleteAuthor(id);
    }
}
