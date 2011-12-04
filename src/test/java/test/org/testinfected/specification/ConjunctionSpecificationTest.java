package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testinfected.specification.ConjunctionSpecification.with;

public class ConjunctionSpecificationTest {

    Object aCandidate = new Object();
    Specification<Object> satisfied = new Tautology<Object>();
    Specification<Object> unsatisfied = new Contradiction<Object>();

    @Test public void
    isSatisfiedWhenAllSpecificationsAreSatisfied() {
        Specification<Object> conjunction = with(satisfied).and(satisfied);
        assertThat("satisfied", conjunction.isSatisfiedBy(aCandidate), is(true));
    }

    @Test public void
    isUnsatisfiedAsSoonAsASingleSpecificationIsUnsatisfied() {
        Specification<Object> conjunction = with(satisfied).and(unsatisfied).and(satisfied);
        assertThat("satisfied", conjunction.isSatisfiedBy(aCandidate), is(false));
    }
}
