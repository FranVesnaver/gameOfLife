package colorRule;

import color.Blue;
import color.Color;
import color.Red;
import color.White;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ColorRuleTest {

    private static Stream<Arguments> colorAtBirthTestCaseProvider() {
        NoColorRule noColor = new NoColorRule();
        ImmigrationColorRule immigrationColor = new ImmigrationColorRule();

        Color white = new White();
        Color red = new Red();
        Color blue = new Blue();

        return Stream.of(
                Arguments.of(noColor, List.of(red, red, red), new White()),
                Arguments.of(noColor, List.of(red, blue, white), new White()),
                Arguments.of(noColor, List.of(red, blue, blue), new White())
        );
    }

    @ParameterizedTest
    @MethodSource("colorAtBirthTestCaseProvider")
    public void colorAtBirthTest(ColorRule colorRule, List<Color> input, Color expected) {
        Color result = colorRule.colorAtBirth(input);

        assertEquals(expected, result);
    }

}