package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidThumbnailException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidThumbnailException(final String thumbnail) {
        super(String.format("Thumbnail [%s] is not valid", thumbnail));
    }
}
