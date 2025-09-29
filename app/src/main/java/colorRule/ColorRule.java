package colorRule;

import color.Color;

import java.util.List;

public interface ColorRule {
    Color colorAtBirth(List<Color> neighboursColors);
}
