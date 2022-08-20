package me.test.takehome2022sunkyungcho.exception;

import java.io.IOException;

public class GoogleSheetException extends RuntimeException {
    public GoogleSheetException(IOException e) {
        super(e);
    }

    public GoogleSheetException(String message) {
        super(message);
    }
}
