package test.org.testinfected.specification.testmodel;

import org.testinfected.specification.AbstractSpecification;
import org.testinfected.specification.Specification;

public class WithColor extends AbstractSpecification<Shape> {

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
        return candidate.color() == color;
    }

    @Override public boolean isSpecialCaseOf(Specification<?> other) {
        return other instanceof WithColor && isSpecialCaseOf((WithColor) other);
    }

    @Override public boolean isGeneralizationOf(Specification<?> other) {
        return other instanceof WithColor && isGeneralizationOf((WithColor) other);
    }

    private boolean isSpecialCaseOf(WithColor other) {
        return other.color == color;
    }

    private boolean isGeneralizationOf(WithColor other) {
        return other.isSpecialCaseOf(this);
    }
}
