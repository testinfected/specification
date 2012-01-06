package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ContradictionTest {

    Contradiction<Object> contradiction = Contradiction.none();
    Object anyCandidate = new Object();
    Contradiction<Object> itself = Contradiction.none();
    Specification<Object> anotherSpecification = Tautology.any();

    @Test public void
    isNeverSatisfied() {
        assertThat("satisfied", contradiction.isSatisfiedBy(anyCandidate), is(false));
    }

    @Test public void
    isOnlyMoreGenericThanItself() {
        assertThat("generalization of other", contradiction.isGeneralizationOf(anotherSpecification), is(false));
        assertThat("generalization of self", contradiction.isGeneralizationOf(itself), is(true));
    }

    @Test public void
    isMoreSpecificThanAnyOtherSpecification() {
        assertThat("special case of other", contradiction.isSpecialCaseOf(anotherSpecification), is(true));
    }
}
