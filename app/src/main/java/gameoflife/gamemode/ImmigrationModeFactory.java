package gameoflife.gamemode;

import gameoflife.colorRule.ColorRule;
import gameoflife.colorRule.ImmigrationColorRule;
import gameoflife.rule.ClassicRule;
import gameoflife.rule.Rule;

public class ImmigrationModeFactory implements AbstractGameModeFactory {
    @Override
    public Rule createRule() {
        return new ClassicRule();
    }

    @Override
    public ColorRule createColorRule() {
        return new ImmigrationColorRule();
    }
}
