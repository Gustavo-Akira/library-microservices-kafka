package br.com.gustavoakira.library.users.application.service;

import br.com.gustavoakira.library.users.application.domain.User;
import br.com.gustavoakira.library.users.application.port.UserRepositoryPort;
import br.com.gustavoakira.library.users.application.port.UserServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServicePort {

    private final UserRepositoryPort repository;

    public UserService(UserRepositoryPort repository) {
        this.repository = repository;
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
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean removeUser(Long id) {
        return repository.removeUser(id);
    }
}
