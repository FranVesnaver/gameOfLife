package gameoflife.statebehavior;

public class Dead extends StateBehavior {
    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "Dead";
    }


}
