package br.com.gustavoakira.library.users.application.service;

import br.com.gustavoakira.library.users.application.domain.User;
import br.com.gustavoakira.library.users.application.port.RoleRepositoryPort;
import br.com.gustavoakira.library.users.application.port.UserRepositoryPort;
import br.com.gustavoakira.library.users.application.port.UserServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServicePort {

    private final UserRepositoryPort repository;
    private final RoleRepositoryPort roleRepositoryPort;

    public UserService(UserRepositoryPort repository, RoleRepositoryPort roleRepositoryPort) {
        this.repository = repository;
        this.roleRepositoryPort = roleRepositoryPort;
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
        if(user.getRole() == null){
            user.setRole(roleRepositoryPort.findById(3L));
        }
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
