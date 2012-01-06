package test.org.testinfected.specification.testmodel;

public class Rectangle extends Polygon {

    public static Rectangle white(int width, int length) {
        return new Rectangle(Color.white, width, length);
    }

    public static Rectangle black(int width, int length) {
        return new Rectangle(Color.black, width, length);
    }

    private final int width;
    private final int length;
    private final Color color;

    public Rectangle(Color color, int width, int length) {
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
