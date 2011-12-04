package org.testinfected.specification;

public class Contradiction<T> extends AbstractSpecification<T> {
    public boolean isSatisfiedBy(T candidate) {
        return false;
    }
}
