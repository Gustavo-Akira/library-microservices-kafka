package br.com.gustavoakira.library.users.application.domain.port;

import br.com.gustavoakira.library.users.application.domain.User;

import java.util.List;

public interface UserRepositoryPort {
    List<User> findAll(int page);
    User findById(Long id);
    User save(User user);
}
