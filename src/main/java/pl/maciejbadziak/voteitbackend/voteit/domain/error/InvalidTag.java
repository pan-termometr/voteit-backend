package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidTag extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidTag(final String tag) {
        super(String.format("Tag [%s] is not valid", tag));
    }
}
