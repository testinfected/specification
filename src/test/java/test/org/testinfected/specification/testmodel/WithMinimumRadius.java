package test.org.testinfected.specification.testmodel;

import org.testinfected.specification.Specification;

public class WithMinimumRadius implements Specification<Circle> {

    public static WithMinimumRadius of(int minimum) {
        return new WithMinimumRadius(minimum);
    }

    private final int radius;

    public WithMinimumRadius(int size) {
        this.radius = size;
    }

    public boolean isSatisfiedBy(Circle candidate) {
        return candidate.radius() > radius;
    }

    @Override public boolean isSpecialCaseOf(Specification<?> other) {
        return other instanceof WithMinimumRadius && isSpecialCaseOf((WithMinimumRadius) other);

    }

    @Override public boolean isGeneralizationOf(Specification<?> other) {
        return other instanceof WithMinimumRadius && isGeneralizationOf((WithMinimumRadius) other);
    }

    private boolean isSpecialCaseOf(WithMinimumRadius other) {
        return radius >= other.radius;
    }

    private boolean isGeneralizationOf(WithMinimumRadius other) {
        return other.isSpecialCaseOf(this);
    }
}
