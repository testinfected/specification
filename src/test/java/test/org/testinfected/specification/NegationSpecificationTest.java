package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.NegationSpecification;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NegationSpecificationTest {
    Object aCandidate = new Object();

    @Test public void
    isSatisfiedWhenOppositeSpecificationsIsUnsatisfied() {
        Specification<Object> none = Contradiction.none();
        Specification<Object> any = NegationSpecification.not(none);
        assertThat("satisfied", any.isSatisfiedBy(aCandidate), is(true));
    }

    @Test public void
    isUnsatisfiedWhenOppositeSpecificationsIsSatisfied() {
        Specification<Object> any = Tautology.any();
        Specification<Object> none = NegationSpecification.not(any);
        assertThat("satisfied", none.isSatisfiedBy(aCandidate), is(false));
    }
}
