package org.testinfected.specification;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ConjunctionSpecification<T> extends CompositeSpecification<T> {

    public ConjunctionSpecification(Collection<Specification<T>> components) {
        super(components);
    }

    public boolean isSatisfiedBy(T candidate) {
        for (Specification<T> specification : components()) {
            if (!specification.isSatisfiedBy(candidate)) return false;
        }

        return true;
    }

    @SuppressWarnings({"unchecked", "varargs"})
    public static <T> ConjunctionSpecification<T> with(Specification<T>... components) {
        return new ConjunctionSpecification<T>(Arrays.asList(components));
    }

    public ConjunctionSpecification<T> and(Specification<T> component) {
        add(component);
        return this;
    }
}
