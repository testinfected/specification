package org.testinfected.specification;

public interface Specification<T> {

    boolean isSatisfiedBy(T candidate);

    default boolean isSpecialCaseOf(Specification<?> other) {
        return false;
    }

    default boolean isGeneralizationOf(Specification<?> other) {
        return false;
    }

//    default boolean isGeneralizationOfLeaf(Specification<?> leaf) {
//        return false;
//    }
//
//    default boolean isSpecialCaseOfLeaf(Specification<?> leaf) {
//        return false;
//    }
}
