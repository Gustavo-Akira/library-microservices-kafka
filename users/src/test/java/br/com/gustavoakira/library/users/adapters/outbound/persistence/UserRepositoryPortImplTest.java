package br.com.gustavoakira.library.users.adapters.outbound.persistence;

import br.com.gustavoakira.library.users.adapters.outbound.persistence.entities.UserEntity;
import br.com.gustavoakira.library.users.application.domain.User;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserRepositoryPortImplTest {
    @InjectMocks
    private UserRepositoryPortImpl userRepositoryPort;

    @Mock
    private SpringDataUserRepository repository;

    @Test
    void findAll() {
        List<UserEntity> entities = Instancio.stream(UserEntity.class).limit(3).collect(Collectors.toList());

        Mockito.when(repository.findAll(Pageable.ofSize(5).withPage(0))).thenReturn(new PageImpl<>(entities));
        List<User> users = userRepositoryPort.findAll(0);
        assertAll(
                ()-> assertEquals(entities.size(), users.size()),
                ()->assertEquals(entities.get(0).getEmail(), users.get(0).getEmail())
        );
    }

    @Test
    void findById() {
        UserEntity entity = Instancio.create(UserEntity.class);
        entity.setId(1L);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entity));
        assertAll(
                ()->assertDoesNotThrow(()->userRepositoryPort.findById(1L)),
                ()->assertEquals(entity.getEmail(), userRepositoryPort.findById(1L).getEmail())
        );
    }

    @Test
    void save() {
        UserEntity entity = Instancio.create(UserEntity.class);
        entity.setId(null);
        Mockito.when(repository.save(entity)).thenReturn(entity);
        assertNotNull(userRepositoryPort.save(entity.toDomain()));
    }

    @Test
    void findByEmail() {
        UserEntity entity = Instancio.create(UserEntity.class);
        entity.setId(1L);
        Mockito.when(repository.findByEmail(entity.getEmail())).thenReturn(Optional.of(entity));
        assertAll(
                ()->assertDoesNotThrow(()->userRepositoryPort.findByEmail(entity.getEmail())),
                ()->assertEquals(entity.getEmail(), userRepositoryPort.findByEmail(entity.getEmail()).getEmail())
        );
    }

    @Test
    void removeUser() {
        Mockito.doNothing().when(repository).deleteById(1L);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(Instancio.create(UserEntity.class)));
        assertTrue(userRepositoryPort.removeUser(1L));
    }
}