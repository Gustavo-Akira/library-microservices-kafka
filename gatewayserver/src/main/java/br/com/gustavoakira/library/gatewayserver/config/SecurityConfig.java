package br.com.gustavoakira.library.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity security){
        security.authorizeExchange(exchanges->exchanges
                .pathMatchers(HttpMethod.GET).permitAll()
                .pathMatchers(HttpMethod.GET,"/users/**").authenticated()
                .pathMatchers(HttpMethod.PUT,"/users/**").authenticated()
                .pathMatchers(HttpMethod.DELETE,"/users/**").authenticated()
                .pathMatchers(HttpMethod.POST,"/users/**").permitAll()
                .pathMatchers("/authors/**").authenticated()
        ).oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec.jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(authoritiesExtractor())));
        security.csrf(ServerHttpSecurity.CsrfSpec::disable);
        return security.build();
    }

    private Converter<Jwt, Mono<AbstractAuthenticationToken>> authoritiesExtractor(){
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());
        return new ReactiveJwtAuthenticationConverterAdapter(converter);
    }
}
