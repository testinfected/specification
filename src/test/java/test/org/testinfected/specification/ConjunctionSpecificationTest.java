package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.ConjunctionSpecification;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ConjunctionSpecificationTest {

    Object aCandidate = new Object();
    Specification<Object> any = Tautology.any();
    Specification<Object> none = Contradiction.none();

    @Test public void
    isSatisfiedWhenAllSpecificationsAreSatisfied() {
        Specification<Object> conjunction = ConjunctionSpecification.with(any).and(any);
        assertThat("satisfied", conjunction.isSatisfiedBy(aCandidate), is(true));
    }

    @Test public void
    isUnsatisfiedAsSoonAsASingleSpecificationIsUnsatisfied() {
        Specification<Object> conjunction = ConjunctionSpecification.with(any).and(none).and(any);
        assertThat("satisfied", conjunction.isSatisfiedBy(aCandidate), is(false));
    }
}
