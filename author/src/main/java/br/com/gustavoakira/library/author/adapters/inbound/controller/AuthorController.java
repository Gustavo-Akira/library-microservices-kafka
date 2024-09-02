package br.com.gustavoakira.library.author.adapters.inbound.controller;

import br.com.gustavoakira.library.author.adapters.dto.AuthorReturnDTO;
import br.com.gustavoakira.library.author.adapters.dto.SaveAuthorDTO;
import br.com.gustavoakira.library.author.adapters.dto.UpdateAuthorDTO;
import br.com.gustavoakira.library.author.application.ports.AuthorServicePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorServicePort port;



    @PostMapping
    public Mono<AuthorReturnDTO> saveAuthor(@Valid SaveAuthorDTO author){
        return port.saveAuthor(author.toDomain()).map(AuthorReturnDTO::fromDomain);
    }
    @PutMapping
    public Mono<AuthorReturnDTO> saveAuthor(@Valid UpdateAuthorDTO author){
        return port.saveAuthor(author.toDomain()).map(AuthorReturnDTO::fromDomain);
    }
    @GetMapping("/author/{name}/{page}")
    public Flux<AuthorReturnDTO> findAuthorsByName(String name, Integer page){
        return port.findAuthorsByName(name,page).map(AuthorReturnDTO::fromDomain);
    }
    @GetMapping("/{id}")
    public Mono<AuthorReturnDTO> findAuthorById(Long id){
        return port.findAuthorById(id).map(AuthorReturnDTO::fromDomain);
    }
    @GetMapping("/page/{page}")
    public Flux<AuthorReturnDTO> findAuthors(Integer page){
        return port.findAuthors(page).map(AuthorReturnDTO::fromDomain);
    }
    @GetMapping("")
    public Flux<AuthorReturnDTO> findAuthors(){
        return port.findAuthors(0).map(AuthorReturnDTO::fromDomain);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(Long id){
        return port.deleteAuthor(id);
    }
}
