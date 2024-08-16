package br.com.gustavoakira.library.users.adapters.outbound.persistence;

import br.com.gustavoakira.library.users.adapters.outbound.persistence.entities.RoleEntity;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class RoleRepositoryPortImplTest {

    @InjectMocks
    private RoleRepositoryPortImpl roleRepositoryPort;

    @Mock
    private SpringDataRoleRepository repository;

    @Test
    void findAll() {
        List<RoleEntity> mockedList = Instancio.stream(RoleEntity.class).limit(3).toList();
        Mockito.when(repository.findAll()).thenReturn(mockedList);
        assertAll(()->{
            assertEquals(mockedList.size(),roleRepositoryPort.findAll().size());
            assertEquals(mockedList.get(0).getName(), roleRepositoryPort.findAll().get(0).getName());
        });

    }

    @Test
    void findById() throws Exception {
        RoleEntity roleEntity = new RoleEntity(1L, "administrator");
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(roleEntity));
        assertEquals(roleEntity.toDomain(),roleRepositoryPort.findById(1L));
    }
}