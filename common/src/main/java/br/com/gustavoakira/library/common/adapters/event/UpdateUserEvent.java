package br.com.gustavoakira.library.common.adapters.event;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateUserEvent(@NotEmpty @NotNull String userId, @Email String email) {
}
