package test.org.testinfected.specification.testmodel;

public class Rectangle extends Polygon {

    private final int width;
    private final int length;
    private final Color color;

    public Rectangle(int width, int length, Color color) {
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public int width() {
        return width;
    }

    public int length() {
        return length;
    }

    @Override public int segments() {
        return 4;
    }

    public Color color() {
        return color;
    }
}
