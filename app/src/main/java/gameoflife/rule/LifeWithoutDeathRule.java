package gameoflife.rule;

public class LifeWithoutDeathRule implements Rule {
    @Override
    public boolean survives(int livingNeighbors) {
        return true;
    }

    @Override
    public boolean born(int livingNeighbors) {
        return livingNeighbors == 3;
    }
}
