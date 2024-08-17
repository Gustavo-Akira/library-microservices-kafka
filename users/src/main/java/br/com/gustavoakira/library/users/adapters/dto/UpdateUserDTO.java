package br.com.gustavoakira.library.users.adapters.dto;

import br.com.gustavoakira.library.users.application.domain.Role;
import br.com.gustavoakira.library.users.application.domain.User;

public record UpdateUserDTO(Long id, String name, String email, String password, Long role) {

    public User toDomain() {
        Role userRole = null;
        if(role != 3){
            userRole = role == 2 ? new Role(role,"administrator"): new Role(role,"secretary");
        }
        return new User(id,name,email,password,userRole);
    }
}
