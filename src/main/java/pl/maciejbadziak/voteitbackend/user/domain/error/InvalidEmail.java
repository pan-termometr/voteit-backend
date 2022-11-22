package pl.maciejbadziak.voteitbackend.user.domain.error;

public class InvalidEmail extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidEmail(final String email) {
        super(String.format("Email [%s] is not valid", email));
    }
}
