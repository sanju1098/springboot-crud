package net.javademo.springboot.exception;

public class ResourceNotCreatedException extends RuntimeException {
    public ResourceNotCreatedException(String message) {
        super(message);
    }
}
