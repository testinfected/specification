package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.ConjunctionSpecification;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;
import test.org.testinfected.specification.testmodel.Circle;
import test.org.testinfected.specification.testmodel.Shape;
import test.org.testinfected.specification.testmodel.WithColor;
import test.org.testinfected.specification.testmodel.WithMinimumRadius;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConjunctionSpecificationTest {

    Object aCandidate = new Object();
    Specification<Object> any = Tautology.any();
    Specification<Object> none = Contradiction.none();

    Specification<Circle> mediumCircle = WithMinimumRadius.of(10);
    Specification<Circle> largeCircle = WithMinimumRadius.of(15);
    Specification<Circle> veryLargeCircle = WithMinimumRadius.of(20);
    Specification<Shape> blackShape = WithColor.black();

    @Test public void
    isSatisfiedWhenAllOfItsComponentsAre() {
        Specification<Object> conjunction = ConjunctionSpecification.with(any).and(any);
        assertThat("satisfied", conjunction.isSatisfiedBy(aCandidate), is(true));
    }

    @Test public void
    isUnsatisfiedIfAnyOfItsComponentIsUnsatisfied() {
        Specification<Object> conjunction = ConjunctionSpecification.with(any).and(none).and(any);
        assertThat("satisfied", conjunction.isSatisfiedBy(aCandidate), is(false));
    }

    @Test public void
    isSpecialCaseOfOtherSpecificationIfAnyOfItsComponentIs() {
        Specification<Circle> largeBlackCircle = ConjunctionSpecification.<Circle>with(blackShape).and(largeCircle);
        assertThat("special case of more generic", largeBlackCircle.isSpecialCaseOf(mediumCircle), is(true));
        assertThat("special case of component", largeBlackCircle.isSpecialCaseOf(blackShape), is(true));
        assertThat("special case of more specific", largeBlackCircle.isSpecialCaseOf(veryLargeCircle), is(false));
    }

    @Test public void
    isGeneralizationOfOtherSpecificationIfAllOfItsComponentAre() {
        Specification<Circle> somewhatLargerCircle = ConjunctionSpecification.with(mediumCircle).and(largeCircle);
        assertThat("generalization of more specific", somewhatLargerCircle.isGeneralizationOf(veryLargeCircle), is(true));
        assertThat("generalization of component", somewhatLargerCircle.isGeneralizationOf(largeCircle), is(true));
        assertThat("generalization of more generic", somewhatLargerCircle.isGeneralizationOf(mediumCircle), is(false));
    }
}
