package org.app.infra.util;

import org.app.infra.exception.flow.InvalidParameterException;

public class Checks {

    private Checks() {
    }

    /**
     * Validates that a given condition is {@code true}. If the condition is {@code false},
     * throws an {@link InvalidParameterException} with the provided message.
     *
     * @param check   the condition to validate
     * @param message the exception message if validation fails
     * @throws InvalidParameterException if {@code check} is {@code false}
     */
    public static void checkParameter(boolean check, String message) throws InvalidParameterException {
        if (!check) {
            throw new InvalidParameterException(message);
        }
    }
}
