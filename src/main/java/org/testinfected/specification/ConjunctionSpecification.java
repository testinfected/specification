package org.testinfected.specification;

import java.util.Arrays;
import java.util.Collection;

public class ConjunctionSpecification<T> extends CompositeSpecification<T> {

    private ConjunctionSpecification(Collection<Specification<? super T>> components) {
        super(components);
    }

    public boolean isSatisfiedBy(T candidate) {
        for (Specification<? super T> specification : components()) {
            if (!specification.isSatisfiedBy(candidate)) return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static <T> ConjunctionSpecification<T> with(Specification<? super T> component) {
        return allOf(component);
    }

    @SuppressWarnings("varargs")
    public static <T> ConjunctionSpecification<T> allOf(Specification<? super T>... components) {
        return with(Arrays.asList(components));
    }

    public static <T> ConjunctionSpecification<T> with(Collection<Specification<? super T>> components) {
        return new ConjunctionSpecification<T>(components);
    }

    public ConjunctionSpecification<T> and(Specification<? super T> component) {
        add(component);
        return this;
    }
}
