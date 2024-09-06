package br.com.gustavoakira.library.users.adapters.outbound.persistence.entities;

import br.com.gustavoakira.library.users.application.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long roleId;


    public User toDomain(){
        return new User(id, name, email, password, roleId);
    }

    public static UserEntity fromDomain(User user){
        return new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRoleId());
    }
}
