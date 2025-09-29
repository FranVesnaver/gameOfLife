package color;

import java.util.Objects;

public abstract class Color {
    public abstract String getColor();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Color colorObj)) return false;

        return Objects.equals(this.getColor(), colorObj.getColor());
    }
}
