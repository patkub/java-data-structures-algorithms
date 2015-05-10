/**
 * Created by Patka on 5/10/2015.
 */

package net.datastructures;

public class StackIsEmptyException extends RuntimeException {
    /**
     * Exception when stack is empty.
     * @param message   error message.
     */
    public StackIsEmptyException(String message) {
        super(message);
    }
}
