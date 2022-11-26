package pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.error;

public class InvalidTagnameException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidTagnameException(final String tagname) {
        super(String.format("Tagname: [%s] us not valid", tagname));
    }

}
