package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testinfected.specification.DisjunctionSpecification.either;

public class DisjunctionSpecificationTest {

    Object aCandidate = new Object();
    Specification<Object> any = Tautology.any();
    Specification<Object> none = Contradiction.none();

    @Test public void
    isSatisfiedWhenAtLeastOneSpecificationIsSatisfied() {
         Specification<Object> disjunction = DisjunctionSpecification.either(none).or(any);
         assertThat("satisfied", disjunction.isSatisfiedBy(aCandidate), is(true));
     }

     @Test public void
     isUnsatisfiedWhenAllSpecificationsAreUnsatisfied() {
         Specification<Object> disjunction = DisjunctionSpecification.either(none).or(none).or(none);
         assertThat("satisfied", disjunction.isSatisfiedBy(aCandidate), is(false));
     }

}
