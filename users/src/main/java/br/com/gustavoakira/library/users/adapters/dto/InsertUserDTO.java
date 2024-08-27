package br.com.gustavoakira.library.users.adapters.dto;

import br.com.gustavoakira.library.users.application.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record InsertUserDTO(@NotEmpty String name, @Email String email,@NotEmpty String password) {
    public User toDomain() {
        return new User(name,email,password);
    }
}
