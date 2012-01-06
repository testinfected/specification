package test.org.testinfected.specification.testmodel;

public class Circle implements Shape {

    public static Circle white(int radius) {
        return new Circle(Color.white, radius);
    }

    public static Circle black(int radius) {
        return new Circle(Color.black, radius);
    }

    private final int radius;
    private final Color color;

    public Circle(Color color, int radius) {
        this.radius = radius;
        this.color = color;
    }

    public int radius() {
        return radius;
    }

    public Color color() {
        return color;
    }
}
