package org.testinfected.specification;

public class NegationSpecification<T> implements Specification<T> {

    private final Specification<T> negated;

    public NegationSpecification(Specification<T> negated) {
        this.negated = negated;
    }

    public boolean isSatisfiedBy(T candidate) {
        return !negated.isSatisfiedBy(candidate);
    }

    public static <T> Specification<T> not(Specification<T> negated) {
        return new NegationSpecification<T>(negated);
    }
}
