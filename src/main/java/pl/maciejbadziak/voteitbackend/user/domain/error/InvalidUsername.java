package pl.maciejbadziak.voteitbackend.user.domain.error;

public class InvalidUsername extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidUsername(final String username) {
        super(String.format("Username [%s] is not valid", username));
    }
}
