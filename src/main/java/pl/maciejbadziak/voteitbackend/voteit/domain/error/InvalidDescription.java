package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidDescription extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidDescription(final String description) {
        super(String.format("Description [%s] is not valid", description));
    }
}
