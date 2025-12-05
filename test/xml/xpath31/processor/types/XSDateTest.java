package xml.xpath31.processor.types;

import org.junit.jupiter.api.Test;

import javax.xml.transform.TransformerException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class XSDateTest {

    @Test
    void lt() throws TransformerException {
        final XSDate march = XSDate.parseDate("2000-03-21");
        final XSDate april = XSDate.parseDate("2000-04-21");
        assertTrue(march.lt(april));
    }

    @Test
    void gt() throws TransformerException {
        final XSDate march = XSDate.parseDate("2000-03-21");
        final XSDate april = XSDate.parseDate("2000-04-21");
        assertTrue(april.gt(march));
    }
}