package naomi;

/**
 * Exception wrapper for checked exceptions.
 *
 * @author Joao Pedro Evangelista
 * @since 13.02.2016
 */
public class NaomiException extends RuntimeException {

    public NaomiException(Exception e) {
        super(e);
    }

    @SuppressWarnings("unused")
    public NaomiException(String message, Exception e) {
        super(message, e);
    }

    public NaomiException(String message) {
        super(message);
    }
}
