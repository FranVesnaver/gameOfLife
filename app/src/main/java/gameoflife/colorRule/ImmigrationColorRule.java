package gameoflife.colorRule;

import gameoflife.color.Color;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmigrationColorRule implements ColorRule {
    @Override
    public Color colorAtBirth(List<Color> neighboursColors) {
        Map<Color, Integer> appearances = new HashMap<>();

        for (Color color : neighboursColors)
            appearances.put(color, appearances.getOrDefault(color, 0) + 1);

        Color mostAppearances = null;
        int max = -1;

        for (Map.Entry<Color, Integer> entry : appearances.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostAppearances = entry.getKey();
            }
        }

        return mostAppearances;
    }
}
