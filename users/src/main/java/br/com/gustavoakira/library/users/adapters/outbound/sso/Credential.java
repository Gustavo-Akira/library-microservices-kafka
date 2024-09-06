package br.com.gustavoakira.library.users.adapters.outbound.sso;

import org.keycloak.representations.idm.CredentialRepresentation;

public class Credential {
    public static CredentialRepresentation createPasswordCredentials(String password){
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }
}
