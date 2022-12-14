package pl.maciejbadziak.voteitbackend.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.FindUserByEmailPort;

@Component
@RequiredArgsConstructor
public class FindUserByEmailUseCase {

    private final FindUserByEmailPort findUserByEmailPort;

    public User find(final String email) {
        return findUserByEmailPort.findByEmail(email);
    }
}
