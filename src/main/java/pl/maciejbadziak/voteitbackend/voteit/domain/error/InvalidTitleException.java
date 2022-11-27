package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidTitleException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidTitleException(final String title) {
        super(String.format("Title [%s] is not valid", title));
    }
}
