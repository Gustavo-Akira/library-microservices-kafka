package br.com.gustavoakira.library.users.adapters.outbound.persistence;

import br.com.gustavoakira.library.users.adapters.outbound.persistence.entities.RoleEntity;
import br.com.gustavoakira.library.users.application.domain.Role;
import br.com.gustavoakira.library.users.application.port.RoleRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class RoleRepositoryPortImpl implements RoleRepositoryPort {

    private final SpringDataRoleRepository repository;

    public RoleRepositoryPortImpl(SpringDataRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return this.repository.findAll().stream().map(RoleEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Role findById(Long id){
        RoleEntity entity = repository.findById(id).orElseThrow();
        return  entity.toDomain();
    }
}
