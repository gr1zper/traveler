package org.app.infra.util;

import org.app.infra.exception.ConfigurationException;
import org.app.infra.exception.flow.InvalidParameterException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 *
 * @author azubkov
 */
class ReflectionUtilTest {

    @Test
    void createInstanceSuccess() {
        assertNotNull(ReflectionUtil.createInstance(Source.class));
    }

    @Test
    void createInstanceFailure() {
        assertThrows(ConfigurationException.class, () -> ReflectionUtil.createInstance(Restricted.class));
    }

    @Test
    void findSimilarFieldsSuccess() {
        var fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertNotNull(fields);
        assertTrue(fields.contains("value"));
    }

    @Test
    void copyFieldsSuccess() {
        var src = new Source();
        src.setValue(10);
        var dest = new Destination();
        var fields = ReflectionUtil.findSimilarFields(src.getClass(), dest.getClass());

        ReflectionUtil.copyFields(src, dest, fields);
        assertEquals(10, dest.getValue());
    }

    @Test
    void copyFieldsDestinationNullFailure() {
        assertThrows(
                InvalidParameterException.class,
                () -> ReflectionUtil.copyFields(new Source(), null, Collections.emptyList())
        );
    }
}

class Source {
    private int value;
    private String text;

    public void setValue(int value) {
        this.value = value;
    }
}

class Destination {
    private int value;

    public int getValue() {
        return value;
    }
}

class Restricted {
    public Restricted(int value) {
    }
}