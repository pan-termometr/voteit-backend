package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidCreatorException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InvalidCreatorException(final String author) {
        super(String.format("Creator [%s] is not valid", author));
    }
}
