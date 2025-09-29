package rule;

public interface Rule {
    boolean survives(int livingNeighbors);
    boolean born(int livingNeighbors);
}
