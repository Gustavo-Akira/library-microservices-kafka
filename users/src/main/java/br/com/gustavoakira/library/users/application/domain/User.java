package br.com.gustavoakira.library.users.application.domain;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public User(Long id, String name, String email, String password, Role role) throws Exception {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        validate();
    }

    public User(String name, String email, String password, Role role) throws Exception {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        validate();
    }

    private void validate() throws Exception {
        if(this.name == null || this.name.isEmpty()){
            throw new Exception("Name cannot be null");
        }
        if(this.password == null || this.password.isEmpty()){
            throw new Exception("Password cannot be null");
        }
        if(this.email == null || this.email.isEmpty()){
            throw new Exception("Email cannot be null");
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
