package pl.maciejbadziak.voteitbackend.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.FindByUsernamePort;

@Component
@RequiredArgsConstructor
public class FindByUsernameUseCase {

    private final FindByUsernamePort findByUsernamePort;

    public User find(final String username) {
        return findByUsernamePort.findByUsername(username);
    }


}
