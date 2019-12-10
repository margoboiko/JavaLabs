package Lab5_6.exceptions;

public class DatabaseConnectException extends RuntimeException  {
    public DatabaseConnectException(String message) {
        super(message);
    }
}