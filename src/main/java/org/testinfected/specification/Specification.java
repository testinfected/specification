package org.testinfected.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T candidate);

    boolean isSpecialCaseOf(Specification<?> other);

    boolean isGeneralizationOf(Specification<?> other);
}
