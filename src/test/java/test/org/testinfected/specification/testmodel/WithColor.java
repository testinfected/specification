package test.org.testinfected.specification.testmodel;

import org.testinfected.specification.Specification;

public class WithColor implements Specification<Shape> {

    public static Specification<Shape> white() {
        return new WithColor(Color.white);
    }

    public static Specification<Shape> black() {
        return new WithColor(Color.black);
    }

    private final Color color;

    public WithColor(Color color) {
        this.color = color;
    }

    public boolean isSatisfiedBy(Shape candidate) {
        return candidate.color().equals(this.color);
    }
}
