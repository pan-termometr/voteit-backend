package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidThumbnail extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidThumbnail(final String thumbnail) {
        super(String.format("Thumbnail [%s] is not valid", thumbnail));
    }
}
