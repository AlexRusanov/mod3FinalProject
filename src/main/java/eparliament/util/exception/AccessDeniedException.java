package eparliament.util.exception;

/**
 * Created by alexandrrusanov on 9/9/17.
 */
public class AccessDeniedException extends RuntimeException{

    public AccessDeniedException(String message) {
        super(message);
    }
}
