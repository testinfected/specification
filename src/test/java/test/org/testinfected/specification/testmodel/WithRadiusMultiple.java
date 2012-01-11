package test.org.testinfected.specification.testmodel;

import org.testinfected.specification.AbstractSpecification;

public class WithRadiusMultiple extends AbstractSpecification<Circle> {

    public static WithRadiusMultiple of(int base) {
        return new WithRadiusMultiple(base);
    }

    private final int base;

    public WithRadiusMultiple(int base) {
        this.base = base;
    }

    public boolean isSatisfiedBy(Circle candidate) {
        return candidate.radius() % base == 0;
    }
}
