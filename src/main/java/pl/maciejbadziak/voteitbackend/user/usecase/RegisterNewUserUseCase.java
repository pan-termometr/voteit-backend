package pl.maciejbadziak.voteitbackend.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.domain.Email;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.domain.Username;
import pl.maciejbadziak.voteitbackend.user.port.RegisterNewUserPort;
import pl.maciejbadziak.voteitbackend.user.usecase.error.UserAlreadyExistsException;

@Component
@RequiredArgsConstructor
public class RegisterNewUserUseCase {

    private final FindUserByUsernameUseCase findUserByUsernameUseCase;

    private final FindUserByEmailUseCase findUserByEmailUseCase;

    private final RegisterNewUserPort registerNewUserPort;

    public User register(final User user) throws UserAlreadyExistsException {
        checkIfUserExists(user);
        return registerNewUserPort.registerNewUser(user);
    }

    private void checkIfUserExists(final User user) throws UserAlreadyExistsException {
        checkIfEmailExists(user.getEmail());
        checkIfUsernameExists(user.getUsername());
    }

    private void checkIfEmailExists(final Email email) throws UserAlreadyExistsException {
        User user = findUserByEmailUseCase.find(email.getValue());
        if(user != null) {
            throw new UserAlreadyExistsException("There is an account with that email address: " + email.getValue());
        }
    }

    private void checkIfUsernameExists(final Username username) throws UserAlreadyExistsException {
        User user = findUserByUsernameUseCase.find(username.getValue());
        if(user != null) {
            throw new UserAlreadyExistsException("There is an account with that username: " + username.getValue());
        }
    }

}
