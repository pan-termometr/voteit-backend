package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidUrlException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidUrlException(final String url) {
        super(String.format("Url [%s] is not valid", url));
    }
}
