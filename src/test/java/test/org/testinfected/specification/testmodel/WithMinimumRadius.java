package test.org.testinfected.specification.testmodel;

import org.testinfected.specification.Specification;

public class WithMinimumRadius implements Specification<Circle> {

    public static WithMinimumRadius of(int minimum) {
        return new WithMinimumRadius(minimum);
    }

    private final int size;

    public WithMinimumRadius(int size) {
        this.size = size;
    }

    public boolean isSatisfiedBy(Circle candidate) {
        return candidate.radius() > size;
    }
}
