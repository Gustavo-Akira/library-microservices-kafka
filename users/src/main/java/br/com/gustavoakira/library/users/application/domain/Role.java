package br.com.gustavoakira.library.users.application.domain;

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
}
