package org.testinfected.specification;

public abstract class AbstractSpecification<T> implements Specification<T> {

    public boolean isSpecialCaseOf(Specification<?> other) {
        return false;
    }

    public boolean isGeneralizationOf(Specification<?> other) {
        return false;
    }
}
