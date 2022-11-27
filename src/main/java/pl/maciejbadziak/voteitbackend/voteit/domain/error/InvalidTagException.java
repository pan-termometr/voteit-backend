package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidTagException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidTagException(final String tag) {
        super(String.format("Tag [%s] is not valid", tag));
    }
}
