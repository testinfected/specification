package org.testinfected.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T candidate);
}
