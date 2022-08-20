package me.test.takehome2022sunkyungcho.exception;

public class GraphQLClientException extends RuntimeException {

    public GraphQLClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
