package br.com.gustavoakira.library.users.application.service;

import br.com.gustavoakira.library.users.adapters.outbound.sso.KeyCloakService;
import br.com.gustavoakira.library.users.application.domain.User;
import br.com.gustavoakira.library.users.application.port.UserRepositoryPort;
import br.com.gustavoakira.library.users.application.port.UserServicePort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile("!default")
public class UserService implements UserServicePort {

    private final UserRepositoryPort repository;
    private final KeyCloakService service;

    public UserService(UserRepositoryPort repository, KeyCloakService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public List<User> findAll(int page) {
        return repository.findAll(page);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        User savedUser = repository.save(user);
        if(user.getId() == null) {
            service.saveUser(savedUser);
        }else{
            service.updateUser(savedUser);
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean removeUser(Long id) {
        boolean result =  repository.removeUser(id);
        service.deleteUser(id);
        return result;
    }
}
