package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidDescriptionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidDescriptionException(final String description) {
        super(String.format("Description [%s] is not valid", description));
    }
}
