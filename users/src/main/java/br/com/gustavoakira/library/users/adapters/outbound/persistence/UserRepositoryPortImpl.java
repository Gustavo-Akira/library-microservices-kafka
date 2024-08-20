package br.com.gustavoakira.library.users.adapters.outbound.persistence;

import br.com.gustavoakira.library.common.adapters.event.UpdateUserEvent;
import br.com.gustavoakira.library.users.adapters.outbound.persistence.entities.UserEntity;
import br.com.gustavoakira.library.users.adapters.outbound.producer.UpdatedUserInformationProducer;
import br.com.gustavoakira.library.users.application.domain.User;
import br.com.gustavoakira.library.users.application.port.UserRepositoryPort;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryPortImpl implements UserRepositoryPort {

    private final SpringDataUserRepository repository;
    private final UpdatedUserInformationProducer producer;

    public UserRepositoryPortImpl(SpringDataUserRepository repository, UpdatedUserInformationProducer producer) {
        this.repository = repository;
        this.producer = producer;
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
        if(this.repository.findById(user.getId()).isPresent()){
            this.producer.send(new UpdateUserEvent(user.getId().toString(),user.getEmail()));
        }
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
