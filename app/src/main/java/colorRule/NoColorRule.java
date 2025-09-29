package colorRule;

import color.Color;
import color.White;

import java.util.List;

public class NoColorRule implements ColorRule {

    @Override
    public Color colorAtBirth(List<Color> neighboursColors) {
        return new White();
    }
}
