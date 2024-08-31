package br.com.gustavoakira.library.books.adapters.outbound.persistence;

import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.BookDocument;
import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.EBookDocument;
import br.com.gustavoakira.library.books.adapters.outbound.persistence.entity.PhysicalBookDocument;
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

    @Autowired
    private MongoDBAudioBookRepository audioBookRepository;

    @Autowired
    private MongoDBBookRepository repository;

    @Autowired
    private MongoDBEBookRepository eBookRepository;

    @Autowired
    private MongoDBPhysicalBookRepository physicalBookRepository;

    @Override
    public Mono<Book> findBook(String id) {


        return repository.findById(id).map(BookDocument::toDomain);
    }

    @Override
    public Mono<Book> saveBook(Book book) {
        if(book instanceof PhysicalBook){
            return physicalBookRepository.save(PhysicalBookDocument.fromDomain((PhysicalBook) book)).map(PhysicalBookDocument::toDomain);
        }else if(book instanceof EBook){
            return eBookRepository.save(EBookDocument.fromDomain((EBook) book)).map(EBookDocument::toDomain);
        }else{
            return audioBookRepository.save();
        }

    }

    @Override
    public Flux<Book> findAllBooks(Integer page) {
        return repository.findAll().map(BookDocument::toDomain);
    }

    @Override
    public Mono<Boolean> deleteBook(String id) {
        return repository.findById(id).doOnNext(bookDocument -> repository.delete(bookDocument)).thenReturn(true);
    }


}
