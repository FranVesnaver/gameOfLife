package gameoflife.statebehavior;

public abstract class StateBehavior {
    public abstract boolean isAlive();
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StateBehavior state)) return false;

        return this.isAlive() == state.isAlive();
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(isAlive());
    }
}
