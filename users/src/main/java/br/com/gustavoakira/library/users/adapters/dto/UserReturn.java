package br.com.gustavoakira.library.users.adapters.dto;

import br.com.gustavoakira.library.users.application.domain.User;

public record UserReturn(Long id, String name, String email, RoleReturn roleReturn){
    public static UserReturn fromDomain(User user){
        return new UserReturn(user.getId(), user.getName(), user.getEmail(), RoleReturn.fromDomain(user.getRole()));
    }
}
