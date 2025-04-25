package org.app.infra.exception;

import org.app.infra.exception.base.AppException;

/**
 * Signal about exceptional cases in the application logic
 * @author azubkov
 */
public class FlowException extends AppException {

    private static final long serialVersionUID = -2889607185988464072L;

    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlowException(String message) {
        super(message);
    }

}
