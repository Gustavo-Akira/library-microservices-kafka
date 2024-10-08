package br.com.gustavoakira.library.users.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long roleId;

    public User(Long id, String name, String email, String password, Long roleId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        validate();
    }


    public User(String name, String email, String password, Long roleId)  {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        validate();
    }

    private void validate(){
        if(this.name == null || this.name.isEmpty()){
            throw new InvalidDomainConversionException("Name cannot be null");
        }
        if(this.password == null || this.password.isEmpty()){
            throw new InvalidDomainConversionException("Password cannot be null");
        }
        if(this.email == null || this.email.isEmpty()){
            throw new InvalidDomainConversionException("Email cannot be null");
        }
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

    public Long getRoleId() {
        return roleId;
    }
}
