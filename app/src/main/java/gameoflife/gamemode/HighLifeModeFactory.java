package gameoflife.gamemode;

import gameoflife.colorRule.ColorRule;
import gameoflife.colorRule.ImmigrationColorRule;
import gameoflife.rule.HighLifeRule;
import gameoflife.rule.Rule;

public class HighLifeModeFactory implements AbstractGameModeFactory {

    @Override
    public Rule createRule() {
        return new HighLifeRule();
    }

    @Override
    public ColorRule createColorRule() {
        return new ImmigrationColorRule();
    }
}
