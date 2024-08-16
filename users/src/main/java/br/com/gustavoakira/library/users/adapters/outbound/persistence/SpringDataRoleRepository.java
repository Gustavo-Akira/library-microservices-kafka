package br.com.gustavoakira.library.users.adapters.outbound.persistence;

import br.com.gustavoakira.library.users.adapters.outbound.persistence.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRoleRepository extends JpaRepository<RoleEntity, Long> {
}
