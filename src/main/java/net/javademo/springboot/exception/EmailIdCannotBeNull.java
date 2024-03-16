package net.javademo.springboot.exception;

public class EmailIdCannotBeNull extends RuntimeException {
    public EmailIdCannotBeNull(String message) {
        super(message);
    }
}
