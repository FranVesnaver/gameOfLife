package gameoflife.gamemode;

import gameoflife.colorRule.ColorRule;
import gameoflife.colorRule.NoColorRule;
import gameoflife.rule.ClassicRule;
import gameoflife.rule.Rule;

public class ClassicModeFactory implements AbstractGameModeFactory {

    @Override
    public Rule createRule() {
        return new ClassicRule();
    }

    @Override
    public ColorRule createColorRule() {
        return new NoColorRule();
    }
}
