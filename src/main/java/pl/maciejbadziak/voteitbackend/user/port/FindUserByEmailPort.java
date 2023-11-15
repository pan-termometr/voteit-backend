package pl.maciejbadziak.voteitbackend.user.port;

import pl.maciejbadziak.voteitbackend.user.domain.User;

public interface FindUserByEmailPort {

    User findByEmail(final String email);
}
