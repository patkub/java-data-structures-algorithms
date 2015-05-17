/**
 * Created by Patka on 4/3/2015.
 */

public class NotEnoughSharesException extends RuntimeException {

    /**
     * Exception when not enough shares to sell.
     * @param message   error message.
     */
    public NotEnoughSharesException(String message) {
        super(message);
    }
}
