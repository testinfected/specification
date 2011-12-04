package org.testinfected.specification;

import java.util.Arrays;
import java.util.Collection;

public class DisjunctionSpecification<T> extends CompositeSpecification<T> {

    private DisjunctionSpecification(Collection<Specification<T>> components) {
        super(components);
    }

    public boolean isSatisfiedBy(T candidate) {
        for (Specification<T> component : components()) {
            if (component.isSatisfiedBy(candidate)) return true;
        }

        return false;
    }

    @SuppressWarnings({"unchecked", "varargs"})
    public static <T> DisjunctionSpecification<T> either(Specification<T>... components) {
        return new DisjunctionSpecification<T>(Arrays.asList(components));
    }

    public DisjunctionSpecification or(Specification<T> component) {
        add(component);
        return this;
    }
}

