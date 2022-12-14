package pl.maciejbadziak.voteitbackend.user.usecase.error;

public class UserAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
