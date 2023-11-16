package org.testinfected.specification;

import java.util.Collection;
import java.util.List;

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

    @Override public boolean isSpecialCaseOf(Specification<?> other) {
        for (Specification<? super T> component : components()) {
            if (component.isSpecialCaseOf(other)) return true;
        }
        return false;
    }

    @Override public boolean isGeneralizationOf(Specification<?> other) {
        for (Specification<? super T> component : components()) {
            if (!component.isGeneralizationOf(other)) return false;
        }
        return true;
    }

    public static <T> ConjunctionSpecification<T> with(Specification<? super T> component) {
        return allOf(component);
    }

    @SafeVarargs
    public static <T> ConjunctionSpecification<T> allOf(Specification<? super T>... components) {
        var allOf = List.of(components);
        return with(allOf);
    }

    public static <T> ConjunctionSpecification<T> with(Collection<Specification<? super T>> components) {
        return new ConjunctionSpecification<T>(components);
    }

    public ConjunctionSpecification<T> and(Specification<? super T> component) {
        add(component);
        return this;
    }
}
