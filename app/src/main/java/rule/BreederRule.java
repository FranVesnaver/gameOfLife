package rule;

public class BreederRule implements Rule {
    @Override
    public boolean survives(int livingNeighbors) {
        return livingNeighbors == 1 || livingNeighbors == 3 || livingNeighbors == 5 || livingNeighbors == 7;
    }

    @Override
    public boolean born(int livingNeighbors) {
        return livingNeighbors == 1 || livingNeighbors == 3 || livingNeighbors == 5 || livingNeighbors == 7;
    }
}
