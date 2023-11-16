package org.testinfected.specification;

public final class Tautology<T> implements Specification<T> {
    private Tautology() {}

    public boolean isSatisfiedBy(T candidate) {
        return true;
    }

    public static <T> Tautology<T> any() {
        return new Tautology<T>();
    }

//    public boolean isGeneralizationOfLeaf(Specification<?> leaf) {
//        return isGeneralizationOf(leaf);
//    }
//
//    public boolean isGeneralizationOf(Specification<?> other) {
//        return true;
//    }

    public boolean isGeneralizationOf(Specification<?> other) {
        return true;
    }

//    public boolean isSpecialCaseOfLeaf(Specification<?> leaf) {
//        return false;
//    }
//
//    public boolean isSpecialCaseOf(Specification<?> other) {
//        return other.isGeneralizationOf(this);
//    }

    public boolean isSpecialCaseOf(Specification<?> other) {
        return other instanceof Tautology ;
    }
}
