package gameoflife.rule;

public class ClassicRule implements Rule {

    @Override
    public boolean survives(int livingNeighbors) {
        return livingNeighbors >= 2 && livingNeighbors <= 3;
    }

    @Override
    public boolean born(int livingNeighbors) {
        return livingNeighbors == 3;
    }
}
