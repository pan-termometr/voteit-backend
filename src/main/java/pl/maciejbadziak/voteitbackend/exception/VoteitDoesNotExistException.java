package pl.maciejbadziak.voteitbackend.exception;

public class VoteitDoesNotExistException extends RuntimeException{

    public VoteitDoesNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
