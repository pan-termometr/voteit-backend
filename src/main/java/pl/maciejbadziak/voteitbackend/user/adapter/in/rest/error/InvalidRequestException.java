package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.error;

public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidRequestException(final String username) {
        super(String.format("Requested user: [%s] is not valid ", username));
    }

}
