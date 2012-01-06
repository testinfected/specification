package org.testinfected.specification;

public final class Tautology<T> extends AbstractSpecification<T> {
    private Tautology() {}

    public boolean isSatisfiedBy(T candidate) {
        return true;
    }

    public static <T> Tautology<T> any() {
        return new Tautology<T>();
    }

    public boolean isGeneralizationOf(Specification<? extends T> other) {
        return true;
    }

    public boolean isSpecialCaseOf(Specification<? super T> other) {
        return other instanceof Tautology;
    }
}
