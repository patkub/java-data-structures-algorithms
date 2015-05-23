//QueueIsEmptyException - Patrick Kubiak - 5/10/2015
//Thrown when the queue is empty.

package net.datastructures;

public class QueueIsEmptyException extends RuntimeException {
    /**
     * Exception when stack is empty.
     *
     * @param message error message.
     */
    public QueueIsEmptyException(String message) {
        super(message);
    }
}
