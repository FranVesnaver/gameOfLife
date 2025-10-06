package gameoflife.stateBehavior;

public class Alive extends StateBehavior {
    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String toString() {
        return "Alive";
    }
}
