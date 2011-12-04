package test.org.testinfected.specification.testmodel;

import org.testinfected.specification.Specification;

public class WithSizeLargerThan implements Specification<Circle> {

    private final int size;

    public WithSizeLargerThan(int size) {
        this.size = size;
    }

    public boolean isSatisfiedBy(Circle candidate) {
        return candidate.radius() > size;
    }
}
