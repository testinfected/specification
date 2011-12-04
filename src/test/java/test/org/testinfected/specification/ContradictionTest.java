package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.Contradiction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContradictionTest {

    Contradiction<Object> contradiction = new Contradiction<Object>();
    Object anyCandidate = new Object();

    @Test public void
    isNeverSatisfied() {
        assertThat("satisfied", contradiction.isSatisfiedBy(anyCandidate), is(false));
    }
}
