package br.com.gustavoakira.library.books.application.service;

import br.com.gustavoakira.library.books.application.domain.Book;
import br.com.gustavoakira.library.books.application.port.BookRepositoryPort;
import br.com.gustavoakira.library.books.application.port.BookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BookServicePortImpl implements BookServicePort {

    @Autowired
    private BookRepositoryPort port;

    @Override
    public Mono<Book> findBook(String id) {
        return port.findBook(id);
    }

    @Override
    public Mono<Book> saveBook(Book book) {
        return port.saveBook(book);
    }

    @Override
    public Flux<Book> findAllBooks(Integer page) {
        return port.findAllBooks(page);
    }

    @Override
    public Mono<Boolean> deleteBook(String id) {
        return port.deleteBook(id);
    }
}
