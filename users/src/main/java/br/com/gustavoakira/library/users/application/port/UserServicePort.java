package br.com.gustavoakira.library.users.application.port;

import br.com.gustavoakira.library.users.application.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserServicePort {
    List<User> findAll(int page);
    User findById(Long id);
    User save(User user);
    User findByEmail(String email);
    boolean removeUser(Long id);
}
