package br.com.gustavoakira.library.users.adapters.outbound.sso;

import br.com.gustavoakira.library.users.adapters.outbound.persistence.entities.UserEntity;
import br.com.gustavoakira.library.users.application.domain.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Profile("!default")
public class KeyCloakService {
    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    public KeyCloakService(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    public boolean saveUser(User user){
        CredentialRepresentation credential = Credential.createPasswordCredentials(user.getPassword());
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(user.getEmail());
        userRepresentation.setFirstName(user.getName());
        userRepresentation.setLastName(user.getName());
        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setCredentials(Collections.singletonList(credential));
        userRepresentation.setEnabled(true);
        userRepresentation.setId(user.getId().toString());
        userRepresentation.setRealmRoles(Collections.singletonList(""));
        keycloak.realm(realm).users().create(userRepresentation);
        return true;
    }

    public void deleteUser(Long id){
        keycloak.realm(realm).users().delete(id.toString());
    }

    public void updateUser(User entity){
        UserResource resource =  keycloak.realm(realm).users().get(entity.getId().toString());
        CredentialRepresentation credential = Credential.createPasswordCredentials(entity.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(entity.getEmail());
        user.setFirstName(entity.getName());
        user.setLastName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);
        user.setId(entity.getId().toString());
        user.setRealmRoles(resource.getConfiguredUserStorageCredentialTypes());
        resource.update(user);
    }
}
