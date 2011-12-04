package org.testinfected.specification;

import java.util.ArrayList;
import java.util.Collection;

public abstract class CompositeSpecification<T> implements Specification<T> {
    private final Collection<Specification<T>> components = new ArrayList<Specification<T>>();

    protected CompositeSpecification(Collection<Specification<T>> components) {
        this.components.addAll(components);
    }

    protected void add(Specification<T> other) {
        components.add(other);
    }

    protected Iterable<Specification<T>> components() {
        return components;
    }
}
