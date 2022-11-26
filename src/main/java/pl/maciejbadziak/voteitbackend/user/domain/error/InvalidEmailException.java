package pl.maciejbadziak.voteitbackend.user.domain.error;

public class InvalidEmailException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidEmailException(final String email) {
        super(String.format("Email [%s] is not valid", email));
    }
}
