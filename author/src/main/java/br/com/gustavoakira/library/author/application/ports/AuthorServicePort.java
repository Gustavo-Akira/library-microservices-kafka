package br.com.gustavoakira.library.author.application.ports;

import br.com.gustavoakira.library.author.application.domain.Author;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorServicePort {
    Mono<Author> saveAuthor(Author author);
    Flux<Author> findAuthorsByName(String name, Integer page);
    Mono<Author> findAuthorById(Long id);
    Flux<Author> findAuthors(Integer page);
    Mono<Boolean> deleteAuthor(Long id);
}
