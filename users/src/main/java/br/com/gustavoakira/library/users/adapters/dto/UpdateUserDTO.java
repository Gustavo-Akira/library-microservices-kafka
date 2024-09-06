package br.com.gustavoakira.library.users.adapters.dto;

import br.com.gustavoakira.library.users.application.domain.User;

public record UpdateUserDTO(Long id, String name, String email, String password, Long roleId) {

    public User toDomain() {
        return new User(id,name,email,password,roleId);
    }
}
