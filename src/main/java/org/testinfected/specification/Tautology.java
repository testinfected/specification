package org.testinfected.specification;

public class Tautology<T> extends AbstractSpecification<T> {
    public boolean isSatisfiedBy(T candidate) {
        return true;
    }

    public static <T> Specification<T> any() {
        return new Tautology<T>();
    }
}
