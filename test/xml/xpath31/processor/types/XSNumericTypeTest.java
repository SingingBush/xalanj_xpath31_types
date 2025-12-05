package xml.xpath31.processor.types;

import org.apache.xpath.objects.ResultSequence;
import org.junit.jupiter.api.Test;

import javax.xml.transform.TransformerException;

import static org.junit.jupiter.api.Assertions.*;

class XSNumericTypeTest {

    @Test
    void constructor() throws TransformerException {
        assertNull(
                new XSNumericType().constructor(new ResultSequence()), 
                "XSNumericType always returns null for this method"
        );
    }

    @Test
    void typeName() {
        assertNull(
                new XSNumericType().typeName(), 
                "XSNumericType always returns null for this method"
        );
    }

    @Test
    void stringType() {
        assertNull(
                new XSNumericType().stringType(), 
                "XSNumericType always returns null for this method"
        );
    }

    @Test
    void stringValue() {
        assertNull(
                new XSNumericType().stringValue(), 
                "XSNumericType always returns null for this method"
        );
    }
}