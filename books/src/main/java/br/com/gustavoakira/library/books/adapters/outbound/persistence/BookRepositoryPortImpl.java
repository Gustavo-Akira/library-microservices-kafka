package br.com.gustavoakira.library.books.adapters.outbound.persistence;

import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.AudioBookDocument;
import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.BookDocument;
import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.EBookDocument;
import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.PhysicalBookDocument;
import br.com.gustavoakira.library.books.application.domain.AudioBook;
import br.com.gustavoakira.library.books.application.domain.Book;
import br.com.gustavoakira.library.books.application.domain.EBook;
import br.com.gustavoakira.library.books.application.domain.PhysicalBook;
import br.com.gustavoakira.library.books.application.port.BookRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookRepositoryPortImpl implements BookRepositoryPort {



    @Override
    public Mono<Book> findBook(String id) {
        return Mono.empty();
    }

    @Override
    public Mono<Book> saveBook(Book book) {
        return Mono.empty();
    }

    @Override
    public Flux<Book> findAllBooks(Integer page) {
        return Flux.empty();
    }

    @Override
    public Mono<Boolean> deleteBook(String id) {
        return Mono.empty();
    }


}
