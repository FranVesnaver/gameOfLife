package gameoflife.colorRule;

import gameoflife.color.Color;
import gameoflife.color.White;

import java.util.List;

public class NoColorRule implements ColorRule {

    @Override
    public Color colorAtBirth(List<Color> neighboursColors) {
        return new White();
    }
}
