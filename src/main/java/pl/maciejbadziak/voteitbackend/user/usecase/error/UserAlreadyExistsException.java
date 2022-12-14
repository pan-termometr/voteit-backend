package pl.maciejbadziak.voteitbackend.user.usecase.error;

public class UserAlreadyExistException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserAlreadyExistException(final String message) {
        super(message);
    }
}
