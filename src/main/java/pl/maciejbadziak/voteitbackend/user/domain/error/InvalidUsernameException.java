package pl.maciejbadziak.voteitbackend.user.domain.error;

public class InvalidUsernameException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidUsernameException(final String username) {
        super(String.format("Username [%s] is not valid", username));
    }
}
