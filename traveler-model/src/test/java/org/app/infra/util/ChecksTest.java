package org.app.infra.util;

import org.app.infra.exception.flow.InvalidParameterException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChecksTest {

    @Test
    public void testCheckParameterGetException() {
        try {
            Checks.checkParameter(false, "test message");
            fail();
        } catch (Exception ex) {
            assertSame(InvalidParameterException.class, ex.getClass());
            assertSame("test message", ex.getMessage());
        }
    }

    @Test
    public void testCheckParameterNoException() {
        Checks.checkParameter(true, "test message");
        assertTrue(true);
    }
}