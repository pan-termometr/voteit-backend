package pl.maciejbadziak.voteitbackend.voteit.domain.error;

public class InvalidCreator extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InvalidCreator(final String author) {
        super(String.format("Creator [%s] is not valid", author));
    }
}
