package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.AbstractSpecification;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;
import test.org.testinfected.specification.testmodel.Shape;
import test.org.testinfected.specification.testmodel.WithColor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TautologyTest {

    Tautology<Object> tautology = Tautology.any();
    Object anyCandidate = new Object();
    Tautology<Object> itself = Tautology.any();
    Specification<Object> anotherSpecification = Contradiction.none();

    @Test public void
    isAlwaysSatisfied() {
        assertThat("satisfied", tautology.isSatisfiedBy(anyCandidate), is(true));
    }

    @Test public void
    isMoreGenericThanAnyOtherSpecification() {
        assertThat("generalization", tautology.isGeneralizationOf(anotherSpecification), is(true));
    }

    @Test public void
    isOnlyMoreSpecificThanItself() {
        assertThat("special case of other", tautology.isSpecialCaseOf(anotherSpecification), is(false));
        assertThat("special case of self", tautology.isSpecialCaseOf(itself), is(true));
    }

}
