package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidTitle extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidTitle(final String title) {
        super(String.format("Title [%s] is not valid", title));
    }
}
