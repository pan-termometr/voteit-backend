package pl.maciejbadziak.voteitbackend.user.port;

import pl.maciejbadziak.voteitbackend.user.domain.User;

public interface FindUserByUsernamePort {

    User findByUsername(final String username);
}
