//StackIsEmptyException - Patrick Kubiak - 5/10/2015
//Thrown when the stack is empty.

package net.datastructures;

public class StackIsEmptyException extends RuntimeException {
    /**
     * Exception when stack is empty.
     *
     * @param message error message.
     */
    public StackIsEmptyException(String message) {
        super(message);
    }
}
