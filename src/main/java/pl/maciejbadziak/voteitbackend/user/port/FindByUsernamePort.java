package pl.maciejbadziak.voteitbackend.user.port;

import pl.maciejbadziak.voteitbackend.user.domain.User;

public interface FindByUsernamePort {

    User findByUsername(final String username);
}
