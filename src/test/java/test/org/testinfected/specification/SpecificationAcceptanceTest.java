package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Specifications;
import test.org.testinfected.specification.testmodel.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.testinfected.specification.Specifications.allOf;
import static org.testinfected.specification.Specifications.anyOf;
import static org.testinfected.specification.Specifications.not;

public class SpecificationAcceptanceTest {

    Circle aLargeBlackCircle = Circle.black(20);
    Circle aLargeWhiteCircle = Circle.white(20);
    Circle aSmallWhiteCircle = Circle.white(5);
    Circle aHugeWhiteCircle = Circle.white(50);
    Specification<Circle> largeCircle = new WithSizeLargerThan(15);
    Specification<Circle> hugeCircle = new WithSizeLargerThan(35);
    Specification<Shape> blackShape = WithColor.black();
    Specification<Shape> whiteShape = WithColor.white();

    @Test public void
    logicalConjunctionOfSpecifications() {
        Specification<Circle> largeBlackCircle = Specifications.<Circle>with(largeCircle).and(blackShape);
        assertThat("satisfied", largeBlackCircle.isSatisfiedBy(aLargeBlackCircle), is(true));

        Specification<Circle> largeWhiteCircle = Specifications.<Circle>with(whiteShape).and(largeCircle);
        assertThat("satisfied", largeWhiteCircle.isSatisfiedBy(aSmallWhiteCircle), is(false));
    }

    @Test public void
    logicalDisjunctionOfSpecifications() {
        Specification<Circle> largeOrBlackCircle = Specifications.<Circle>either(largeCircle).or(blackShape);
        assertThat("satisfied", largeOrBlackCircle.isSatisfiedBy(aLargeBlackCircle), is(true));

        Specification<Circle> hugeOrBlackCircle = Specifications.<Circle>either(blackShape).or(hugeCircle);
        assertThat("satisfied", hugeOrBlackCircle.isSatisfiedBy(aSmallWhiteCircle), is(false));
    }

    @Test public void
    logicalNegationOfSpecifications() {
        Specification<Circle> blackOrNotLargeCircle = anyOf(blackShape, not(largeCircle));
        assertThat("satisfied", blackOrNotLargeCircle.isSatisfiedBy(aLargeBlackCircle), is(true));
        assertThat("satisfied", blackOrNotLargeCircle.isSatisfiedBy(aSmallWhiteCircle), is(true));
        assertThat("satisfied", blackOrNotLargeCircle.isSatisfiedBy(aLargeWhiteCircle), is(false));

        Specification<Circle> smallWhiteCircle = allOf(whiteShape, not(largeCircle));
        assertThat("satisfied", smallWhiteCircle.isSatisfiedBy(aSmallWhiteCircle), is(true));
        assertThat("satisfied", smallWhiteCircle.isSatisfiedBy(aHugeWhiteCircle), is(false));

    }
}
