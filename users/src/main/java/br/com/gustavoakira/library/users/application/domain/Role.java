package br.com.gustavoakira.library.users.application.domain;

import java.util.Objects;

public class Role {
    private Long id;
    private String name;
    public Role(String name) throws Exception {
        this.name = name;
        validate();
    }

    public  Role(Long id, String name) throws Exception {
        this.id = id;
        this.name = name;
        validate();
    }

    private void validate() throws Exception {
        if(this.name == null || this.name.isEmpty()){
            throw new Exception("");
        }
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
