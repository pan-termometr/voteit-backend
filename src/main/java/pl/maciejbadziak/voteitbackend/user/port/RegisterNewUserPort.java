package pl.maciejbadziak.voteitbackend.user.port;

import pl.maciejbadziak.voteitbackend.user.domain.User;

public interface RegisterNewUserPort {

    User registerNewUser(final User user);
}
