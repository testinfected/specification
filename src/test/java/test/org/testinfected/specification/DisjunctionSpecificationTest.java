package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.DisjunctionSpecification;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DisjunctionSpecificationTest {

    Object aCandidate = new Object();
    Specification satisfied = new Tautology();
    Specification unsatisfied = new Contradiction();

    @Test public void
    isSatisfiedWhenAtLeastOneSpecificationIsSatisfied() {
         Specification disjunction = DisjunctionSpecification.either(unsatisfied).or(satisfied);
         assertThat("satisfied", disjunction.isSatisfiedBy(aCandidate), is(true));
     }

     @Test public void
     isUnsatisfiedWhenAllSpecificationsAreUnsatisfied() {
         Specification disjunction = DisjunctionSpecification.either(unsatisfied).or(unsatisfied).or(unsatisfied);
         assertThat("satisfied", disjunction.isSatisfiedBy(aCandidate), is(false));
     }

}
