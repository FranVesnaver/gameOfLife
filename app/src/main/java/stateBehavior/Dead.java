package stateBehavior;

public class Dead implements StateBehavior {
    @Override
    public boolean isAlive() {
        return false;
    }
}
