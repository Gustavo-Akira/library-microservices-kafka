package br.com.gustavoakira.library.users.adapters.outbound.persistence;

import br.com.gustavoakira.library.users.adapters.outbound.persistence.entities.UserEntity;
import br.com.gustavoakira.library.users.application.domain.User;
import br.com.gustavoakira.library.users.application.domain.port.UserRepositoryPort;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserRepositoryPortImpl implements UserRepositoryPort {

    private final SpringDataUserRepository repository;

    public UserRepositoryPortImpl(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll(int page) {
        return this.repository.findAll(Pageable.ofSize(5).withPage(page)).map(UserEntity::toDomain).stream().toList();
    }

    @Override
    public User findById(Long id) {
        return this.repository.findById(id).orElseThrow().toDomain();
    }

    @Override
    public User save(User user) {
        return this.repository.save(UserEntity.fromDomain(user)).toDomain();
    }

    @Override
    public User findByEmail(String email) {
        return this.repository.findByEmail(email).orElseThrow().toDomain();
    }

    @Override
    public boolean removeUser(Long id) {
        if(this.repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
