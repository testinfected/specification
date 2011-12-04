package org.testinfected.specification;

import java.util.Arrays;
import java.util.Collection;

public class DisjunctionSpecification<T> extends CompositeSpecification<T> {

    private DisjunctionSpecification(Collection<Specification<? super T>> components) {
        super(components);
    }

    public boolean isSatisfiedBy(T candidate) {
        for (Specification<? super T> component : components()) {
            if (component.isSatisfiedBy(candidate)) return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public static <T> DisjunctionSpecification<T> either(Specification<? super T> component) {
        return anyOf(component);
    }

    @SuppressWarnings("varargs")
    public static <T> DisjunctionSpecification<T> anyOf(Specification<? super T>... components) {
        return either(Arrays.asList(components));
    }

    public static <T> DisjunctionSpecification<T> either(Collection<Specification<? super T>> components) {
        return new DisjunctionSpecification<T>(components);
    }

    public DisjunctionSpecification<T> or(Specification<? super T> component) {
        add(component);
        return this;
    }
}

