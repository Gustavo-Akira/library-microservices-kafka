package br.com.gustavoakira.library.books.application.port;

import br.com.gustavoakira.library.books.application.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookServicePort {
    Mono<Book> findBook(String id);
    Mono<Book> saveBook(Book book);
    Flux<Book> findAllBooks(Integer page);
    Mono<Boolean> deleteBook(String id);
}
