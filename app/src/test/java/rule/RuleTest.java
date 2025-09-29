package rule;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    private static Stream<Arguments> survivesTestCaseProvider() {
        ClassicRule classic = new ClassicRule();
        HighLifeRule highLife = new HighLifeRule();
        LifeWithoutDeathRule lifeWithoutDeath = new LifeWithoutDeathRule();
        DiffusionRule diffusion = new DiffusionRule();
        BreederRule breeder = new BreederRule();

        return Stream.of(
                Arguments.of(classic, 0, false),
                Arguments.of(classic, 1, false),
                Arguments.of(classic, 2, true),
                Arguments.of(classic, 3, true),
                Arguments.of(classic, 4, false),
                Arguments.of(classic, 5, false),
                Arguments.of(classic, 6, false),

                Arguments.of(highLife, 0, false),
                Arguments.of(highLife, 1, false),
                Arguments.of(highLife, 2, true),
                Arguments.of(highLife, 3, true),
                Arguments.of(highLife, 4, false),
                Arguments.of(highLife, 5, false),
                Arguments.of(highLife, 6, false),

                Arguments.of(lifeWithoutDeath, 0, true),
                Arguments.of(lifeWithoutDeath, 1, true),
                Arguments.of(lifeWithoutDeath, 2, true),
                Arguments.of(lifeWithoutDeath, 3, true),
                Arguments.of(lifeWithoutDeath, 4, true),
                Arguments.of(lifeWithoutDeath, 5, true),
                Arguments.of(lifeWithoutDeath, 6, true),

                Arguments.of(diffusion, 0, false),
                Arguments.of(diffusion, 1, false),
                Arguments.of(diffusion, 2, true),
                Arguments.of(diffusion, 3, false),
                Arguments.of(diffusion, 4, false),
                Arguments.of(diffusion, 5, false),
                Arguments.of(diffusion, 6, false),

                Arguments.of(breeder, 0, false),
                Arguments.of(breeder, 1, true),
                Arguments.of(breeder, 2, false),
                Arguments.of(breeder, 3, true),
                Arguments.of(breeder, 4, false),
                Arguments.of(breeder, 5, true),
                Arguments.of(breeder, 6, false),
                Arguments.of(breeder, 7, true)
        );
    }

    private static Stream<Arguments> bornTestCaseProvider() {
        ClassicRule classic = new ClassicRule();
        HighLifeRule highLife = new HighLifeRule();
        LifeWithoutDeathRule lifeWithoutDeath = new LifeWithoutDeathRule();
        DiffusionRule diffusion = new DiffusionRule();
        BreederRule breeder = new BreederRule();

        return Stream.of(
                Arguments.of(classic, 0, false),
                Arguments.of(classic, 1, false),
                Arguments.of(classic, 2, false),
                Arguments.of(classic, 3, true),
                Arguments.of(classic, 4, false),
                Arguments.of(classic, 5, false),
                Arguments.of(classic, 6, false),

                Arguments.of(highLife, 0, false),
                Arguments.of(highLife, 1, false),
                Arguments.of(highLife, 2, false),
                Arguments.of(highLife, 3, true),
                Arguments.of(highLife, 4, false),
                Arguments.of(highLife, 5, false),
                Arguments.of(highLife, 6, true),

                Arguments.of(lifeWithoutDeath, 0, false),
                Arguments.of(lifeWithoutDeath, 1, false),
                Arguments.of(lifeWithoutDeath, 2, false),
                Arguments.of(lifeWithoutDeath, 3, true),
                Arguments.of(lifeWithoutDeath, 4, false),
                Arguments.of(lifeWithoutDeath, 5, false),
                Arguments.of(lifeWithoutDeath, 6, false),

                Arguments.of(diffusion, 0, false),
                Arguments.of(diffusion, 1, false),
                Arguments.of(diffusion, 2, false),
                Arguments.of(diffusion, 3, false),
                Arguments.of(diffusion, 4, false),
                Arguments.of(diffusion, 5, false),
                Arguments.of(diffusion, 6, false),
                Arguments.of(diffusion, 7, true),

                Arguments.of(breeder, 0, false),
                Arguments.of(breeder, 1, true),
                Arguments.of(breeder, 2, false),
                Arguments.of(breeder, 3, true),
                Arguments.of(breeder, 4, false),
                Arguments.of(breeder, 5, true),
                Arguments.of(breeder, 6, false),
                Arguments.of(breeder, 7, true)
        );
    }


    @ParameterizedTest
    @MethodSource("survivesTestCaseProvider")
    public void survivesTest(Rule rule, int input, boolean expected) {
        boolean result = rule.survives(input);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("bornTestCaseProvider")
    public void bornTest(Rule rule, int input, boolean expected) {
        boolean result = rule.born(input);

        assertEquals(expected, result);
    }
}