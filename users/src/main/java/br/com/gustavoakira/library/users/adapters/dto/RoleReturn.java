package br.com.gustavoakira.library.users.adapters.dto;

import br.com.gustavoakira.library.users.application.domain.Role;

public record RoleReturn(Long id, String name) {
    public static RoleReturn fromDomain(Role role){
        return new RoleReturn(role.getId(), role.getName());
    }
}
