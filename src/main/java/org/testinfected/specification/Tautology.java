package org.testinfected.specification;

public final class Tautology<T> extends AbstractSpecification<T> {
    private Tautology() {}

    public boolean isSatisfiedBy(T candidate) {
        return true;
    }

    public static <T> Tautology<T> any() {
        return new Tautology<T>();
    }

    public boolean isGeneralizationOf(Specification<?> other) {
        return true;
    }

    public boolean isSpecialCaseOf(Specification<?> other) {
        return other instanceof Tautology;
    }
}
