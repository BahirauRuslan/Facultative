package by.bntu.fitr.povt.bahirauruslan.facultative.exceptions;

public class DBDriverNotFoundException extends ClassNotFoundException {
    public DBDriverNotFoundException() {
        super("Database driver not found");
    }
}
