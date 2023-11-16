package org.testinfected.specification;

public final class Contradiction<T> implements Specification<T> {
    private Contradiction() {}

    public boolean isSatisfiedBy(T candidate) {
        return false;
    }

    public static <T> Contradiction<T> none() {
        return new Contradiction<T>();
    }

    public boolean isGeneralizationOf(Specification<?> other) {
        return other.isSpecialCaseOf(this);
    }

    public boolean isSpecialCaseOfLeaf(Specification<?> leaf) {
        return isSpecialCaseOf(leaf);
    }

    public boolean isSpecialCaseOf(Specification<?> other) {
        return true;
    }
}
