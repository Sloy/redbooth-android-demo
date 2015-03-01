package com.sloydev.redbooth.exception;

public class RedboothException extends RuntimeException {
    public RedboothException(Exception e) {
        super(e);
    }

    public RedboothException(String cause) {
        super(cause);
    }
}
