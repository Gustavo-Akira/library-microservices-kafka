package br.com.gustavoakira.library.users.adapters.outbound.persistence.entities;

import br.com.gustavoakira.library.users.application.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RoleEntity {

    @Id
    private Long id;
    @Column()
    private String name;

    public RoleEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role toDomain(){
        return new Role(id,name);
    }
}
