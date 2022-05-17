package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidUrl extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidUrl(final String url) {
        super(String.format("Url [%s] is not valid", url));
    }
}
