package org.app.infra.exception.flow;

import org.app.infra.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method / constructor
 * @author azubkov
 */
public class InvalidParameterException extends FlowException {

    private static final long serialVersionUID = 4990959228756992926L;

    public InvalidParameterException(String message) {
        super(message);
    }

}
