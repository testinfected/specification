package org.testinfected.specification;

public final class Contradiction<T> extends AbstractSpecification<T> {
    private Contradiction() {}

    public boolean isSatisfiedBy(T candidate) {
        return false;
    }

    public static <T> Contradiction<T> none() {
        return new Contradiction<T>();
    }

    public boolean isGeneralizationOf(Specification<?> other) {
        return other instanceof Contradiction;
    }

    public boolean isSpecialCaseOf(Specification<?> other) {
        return true;
    }
}
