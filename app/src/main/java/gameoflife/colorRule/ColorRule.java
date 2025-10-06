package gameoflife.colorRule;

import gameoflife.color.Color;

import java.util.List;

public interface ColorRule {
    Color colorAtBirth(List<Color> neighboursColors);
}
