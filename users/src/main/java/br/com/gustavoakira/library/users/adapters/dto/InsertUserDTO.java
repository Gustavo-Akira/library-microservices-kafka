package br.com.gustavoakira.library.users.adapters.dto;

import br.com.gustavoakira.library.users.application.domain.User;

public record InsertUserDTO(String name, String email, String password) {
    public User toDomain() {
        return new User(name,email,password);
    }
}
