package br.com.gustavoakira.library.users.adapters.inbound.controller;

import br.com.gustavoakira.library.users.adapters.dto.InsertUserDTO;
import br.com.gustavoakira.library.users.adapters.dto.UpdateUserDTO;
import br.com.gustavoakira.library.users.adapters.dto.UserReturn;
import br.com.gustavoakira.library.users.application.domain.User;
import br.com.gustavoakira.library.users.application.port.UserServicePort;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServicePort servicePort;

    public UserController(UserServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<UserReturn>> findAll(@PathVariable Integer page){
        return ResponseEntity.ok(new PageImpl<>(servicePort.findAll(page).stream().map(UserReturn::fromDomain).collect(Collectors.toList())));
    }
    @GetMapping("")
    public ResponseEntity<Page<UserReturn>> findAll(){
        return ResponseEntity.ok(new PageImpl<>(servicePort.findAll(0).stream().map(UserReturn::fromDomain).collect(Collectors.toList())));
    }

    @PostMapping()
    public ResponseEntity<UserReturn> insert(@RequestBody @Valid InsertUserDTO dto){
        UserReturn userReturn = UserReturn.fromDomain(servicePort.save(dto.toDomain()));
        return ResponseEntity.created(URI.create("/users/"+userReturn.id())).body(userReturn);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReturn> findById(@PathVariable Long id){
        return ResponseEntity.ok(UserReturn.fromDomain(servicePort.findById(id)));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserReturn> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(UserReturn.fromDomain(servicePort.findByEmail(email)));
    }

    @PutMapping()
    public ResponseEntity<UserReturn> updateUser(@RequestBody @Valid UpdateUserDTO dto){
        return ResponseEntity.ok(UserReturn.fromDomain(servicePort.save(dto.toDomain())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeUser(@PathVariable Long id){
        return ResponseEntity.ok(servicePort.removeUser(id));
    }
}
