package br.com.gustavoakira.library.users.adapters.configuration;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!default")
@Configuration
public class KeyCloakConfiguration {
    @Value("${keycloak.url}")
    private String serverUrl;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${keycloak.username}")
    private String username;
    @Value("${keycloak.password}")
    private String password;
    @Value("${keycloak.clientId}")
    private String clientId;
    @Value("${keycloak.secret}")
    private String clientSecret;

    @Bean
    public Keycloak keycloak(){

        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .grantType(OAuth2Constants.PASSWORD)
                .username(username)
                .password(password)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .resteasyClient(new ResteasyClientBuilder()
                        .connectionPoolSize(10)
                        .build())
                    .build();
    }
}
