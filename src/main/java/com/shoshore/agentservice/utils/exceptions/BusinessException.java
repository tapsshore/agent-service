package com.shoshore.agentservice.utils.exeptions;

import java.util.Optional;

public class BusinessException extends RuntimeException{


    private static final long serialVersionUID = 1L;
    private final transient Optional<String> friendlyMessage;

    public BusinessException(String message, String friendlyMessage) {
        super(message);
        this.friendlyMessage = Optional.of(friendlyMessage);
    }

    public BusinessException(String message, String friendlyMessage, Throwable cause) {
        super(message, cause);
        this.friendlyMessage = Optional.of(friendlyMessage);
    }

    public BusinessException(String message) {
        super(message);
        this.friendlyMessage = Optional.empty();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.friendlyMessage = Optional.empty();
    }

    public Optional<String> getFriendlyMessage() {
        return this.friendlyMessage;
    }
}
