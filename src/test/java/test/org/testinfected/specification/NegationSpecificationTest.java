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
        Specification spec = new Contradiction();
        Specification negation = new NegationSpecification(spec);
        assertThat("satisfied", negation.isSatisfiedBy(aCandidate), is(true));
    }

    @Test public void
    isUnsatisfiedWhenOppositeSpecificationsIsSatisfied() {
        Specification spec = new Tautology();
        Specification negation = new NegationSpecification(spec);
        assertThat("satisfied", negation.isSatisfiedBy(aCandidate), is(false));
    }
}
