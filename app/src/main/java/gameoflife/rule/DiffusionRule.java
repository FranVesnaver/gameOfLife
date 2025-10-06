package gameoflife.rule;

public class DiffusionRule implements Rule {
    @Override
    public boolean survives(int livingNeighbors) {
        return livingNeighbors == 2;
    }

    @Override
    public boolean born(int livingNeighbors) {
        return livingNeighbors == 7;
    }
}
