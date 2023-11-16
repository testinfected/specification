package org.testinfected.specification;

import java.util.Collection;
import java.util.List;

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

    public static <T> DisjunctionSpecification<T> either(Specification<? super T> component) {
        return either(List.of(component));
    }

    @SafeVarargs
    public static <T> DisjunctionSpecification<T> anyOf(Specification<? super T>... components) {
        var anyOf = List.of(components);
        return either(anyOf);
    }

    public static <T> DisjunctionSpecification<T> either(List<Specification<? super T>> components) {
        return new DisjunctionSpecification<>(components);
    }

    public DisjunctionSpecification<T> or(Specification<? super T> component) {
        add(component);
        return this;
    }
}

