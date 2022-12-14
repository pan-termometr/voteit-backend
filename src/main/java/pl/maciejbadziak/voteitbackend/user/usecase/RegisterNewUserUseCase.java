package pl.maciejbadziak.voteitbackend.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.RegisterNewUserPort;

@Component
@RequiredArgsConstructor
public class RegisterNewUserUseCase {

    private final RegisterNewUserPort registerNewUserPort;

    public User register(final User user) {
        return registerNewUserPort.registerNewUser(user);
    }

}
