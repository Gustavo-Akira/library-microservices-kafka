package br.com.gustavoakira.library.users.adapters.outbound.persistence.entities;

import br.com.gustavoakira.library.users.application.domain.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public static RoleEntity fromDomain(Role role){
        return new RoleEntity(role.getId(), role.getName());
    }
}
