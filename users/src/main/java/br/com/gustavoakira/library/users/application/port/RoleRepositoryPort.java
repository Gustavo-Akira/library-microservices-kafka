package br.com.gustavoakira.library.users.application.port;

import br.com.gustavoakira.library.users.application.domain.Role;

import java.util.List;

public interface RoleRepositoryPort {
    List<Role> findAll();
    Role findById(Long id);
}
