package by.bntu.fitr.povt.bahirauruslan.facultative.exceptions;

public class ConnectionPullOverflowException extends Exception {
    public ConnectionPullOverflowException() {
        super("Connection pull is full");
    }
}
