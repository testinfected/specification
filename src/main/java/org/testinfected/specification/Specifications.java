package org.testinfected.specification;

public final class Specifications {

    private Specifications() {}

    public static <T> ConjunctionSpecification<T> with(Specification<? super T> specification) {
        return ConjunctionSpecification.with(specification);
    }

    @SafeVarargs
    public static <T> ConjunctionSpecification<T> allOf(Specification<? super T>... specifications) {
        return ConjunctionSpecification.allOf(specifications);
    }

    public static <T> DisjunctionSpecification<T> either(Specification<? super T> specification) {
        return DisjunctionSpecification.either(specification);
    }

    @SafeVarargs
    public static <T> DisjunctionSpecification<T> anyOf(Specification<? super T>... specifications) {
        return DisjunctionSpecification.anyOf(specifications);
    }

    public static <T> Specification<T> not(Specification<T> negated) {
        return NegationSpecification.not(negated);
    }

    public static <T> Specification<T> any() {
        return Tautology.any();
    }

    public static <T> Specification<T> none() {
        return Contradiction.none();
    }
}
