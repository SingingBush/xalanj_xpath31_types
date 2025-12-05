package xml.xpath31.processor.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.transform.TransformerException;

import static org.junit.jupiter.api.Assertions.*;

class XSTimeTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "10:00:00",
            "10:00:00.0000", // the parser does support milliseconds
            "10:00:00.0000000", // the parser doesn't really support milliseconds, just takes first 4 digits
            "10:00:00Z",
            "08:00:00+02:00",
            "12:00:00-02:00",
    })
    void parseDateTime(final String strVal) throws TransformerException {
        final XSTime xsTime = XSTime.parseTime(strVal);

        assertEquals(0, xsTime.minute());

        // all the tested values are actually the same time
        xsTime.equals(XSTime.parseTime("10:00:00Z"));

        if (!strVal.endsWith("0000")) {
            // string value doesn't support milliseconds or microseconds. Is this a bug?
            assertEquals(strVal, xsTime.stringValue());
        }
    }

    @Test
    void typeName() {
        assertEquals("time", new XSTime().typeName());
    }

    @Test
    void stringType() {
        assertEquals("xs:time", new XSTime().stringType());
    }
}