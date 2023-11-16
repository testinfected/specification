package org.testinfected.specification;

import java.util.ArrayList;
import java.util.Collection;

public abstract class CompositeSpecification<T> implements Specification<T> {
    private final Collection<Specification<? super T>> components = new ArrayList<>();

    protected CompositeSpecification(Collection<Specification<? super T>> components) {
        this.components.addAll(components);
    }

    protected void add(Specification<? super T> other) {
        components.add(other);
    }

    protected Iterable<Specification<? super T>> components() {
        return components;
    }
}
