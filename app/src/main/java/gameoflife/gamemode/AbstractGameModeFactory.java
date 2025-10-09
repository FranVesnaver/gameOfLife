package gameoflife.gamemode;

import gameoflife.colorRule.ColorRule;
import gameoflife.rule.Rule;

public interface AbstractGameModeFactory {
    Rule createRule();
    ColorRule createColorRule();
}
