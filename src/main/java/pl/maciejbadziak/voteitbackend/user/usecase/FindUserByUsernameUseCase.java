package pl.maciejbadziak.voteitbackend.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.FindUserByUsernamePort;

@Component
@RequiredArgsConstructor
public class FindUserByUsernameUseCase {

    private final FindUserByUsernamePort findUserByUsernamePort;

    public User find(final String username) {
        return findUserByUsernamePort.findByUsername(username);
    }


}
