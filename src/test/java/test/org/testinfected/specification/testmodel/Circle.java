package test.org.testinfected.specification.testmodel;

public class Circle implements Shape {

    private final int radius;
    private final Color color;

    public Circle(int radius, Color color) {
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
