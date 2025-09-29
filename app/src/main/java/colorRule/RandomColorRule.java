package colorRule;

import color.*;

import java.util.List;
import java.util.Random;

public class RandomColorRule implements ColorRule {
    private final List<Color> colors = List.of(new White(), new Red(), new Blue(), new Green(), new Yellow(), new Magenta());

    @Override
    public Color colorAtBirth(List<Color> neighboursColors) {
        return randomColor();
    }

    private Color randomColor() {
        Random random = new Random();
        return colors.get(random.nextInt(0, colors.size()));
    }
}
