package pl.maciejbadziak.voteitbackend.user.usecase.error;

import java.io.Serial;

public class UserAlreadyExistsException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
