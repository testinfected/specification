package test.org.testinfected.specification.testmodel;

import org.testinfected.specification.Specification;

public class WithColor implements Specification<Shape> {

    private final Color color;

    public WithColor(Color color) {
        this.color = color;
    }

    public boolean isSatisfiedBy(Shape candidate) {
        return candidate.color().equals(this.color);
    }
}
