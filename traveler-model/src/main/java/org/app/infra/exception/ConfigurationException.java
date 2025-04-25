package org.app.infra.exception;

import org.app.infra.exception.base.AppException;

/**
 * Signals about incorrect configuration settings / parameters
 * @author azubkov
 */
public class ConfigurationException extends AppException {

    private static final long serialVersionUID = -2177284893894040026L;

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(String message) {
        super(message);
    }

}
