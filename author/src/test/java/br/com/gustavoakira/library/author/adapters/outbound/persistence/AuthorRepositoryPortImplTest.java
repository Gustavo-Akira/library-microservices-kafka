package br.com.gustavoakira.library.author.adapters.outbound.persistence;

import br.com.gustavoakira.library.author.adapters.outbound.persistence.entity.AuthorEntity;
import br.com.gustavoakira.library.author.application.domain.Author;
import br.com.gustavoakira.library.author.application.ports.AuthorRepositoryPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AuthorRepositoryPortImplTest {



    @InjectMocks
    private AuthorRepositoryPortImpl repositoryPort;
    @Mock
    private SpringDataAuthorRepository repository;

    @Test
    void saveAuthor() {
        Author author = Instancio.create(Author.class);
        Mockito.when(repository.save(AuthorEntity.fromDomain(author))).thenReturn(Mono.just(AuthorEntity.fromDomain(author)));
        Mockito.verifyNoMoreInteractions(repository);
        assertEquals(author,repositoryPort.saveAuthor(author).block());
    }

    @Test
    void findAuthorById() {
        Author author = Instancio.create(Author.class);
        Mockito.when(repository.findById(author.getId())).thenReturn(Mono.just(AuthorEntity.fromDomain(author)));
        Mockito.verifyNoMoreInteractions(repository);
        repositoryPort.findAuthorById(author.getId()).subscribe(author1 -> assertEquals(author,author1));
    }


    @Test
    void deleteAuthor() {
        Long id = 1L;
        Mockito.when(repository.deleteById(id)).thenReturn(Mono.empty());
        Mockito.verifyNoMoreInteractions(repository);
        repositoryPort.deleteAuthor(id).subscribe(Assertions::assertTrue);
    }
}