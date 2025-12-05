package xml.xpath31.processor.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XSDurationTest {

    @Test
    void typeName() {
        assertEquals(
                "duration",
                new XSDuration().typeName(),
                "XSDuration always returns 'duration' for this method"
        );
    }

    @Test
    void stringType() {
        assertEquals(
                "xs:duration",
                new XSDuration().stringType(),
                "XSDuration always returns 'xs:duration' for this method"
        );
    }

    @ParameterizedTest
    @MethodSource("expectedStringValues")
    void stringValue(final int seconds, final String expectedValue) {
        assertEquals(
                expectedValue,
                new XSDuration(seconds).stringValue()
        );
        assertEquals(
                Duration.of(seconds, ChronoUnit.SECONDS).toString(),
                new XSDuration(seconds).stringValue(),
                "XSDuration should do the same string format as java.time.Duration"
        );
    }

    private static Stream<Arguments> expectedStringValues() {
        return Stream.of(
                Arguments.of(0, "PT0S"),
                Arguments.of(12, "PT12S"),
                Arguments.of(34, "PT34S"),
                Arguments.of(51, "PT51S"),
                Arguments.of(59, "PT59S"),
                Arguments.of(60, "PT1M"),
                Arguments.of(90, "PT1M30S"),
                Arguments.of(300, "PT5M")
        );
    }

}