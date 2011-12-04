package test.org.testinfected.specification;

import org.junit.Test;
import org.testinfected.specification.Tautology;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TautologyTest {

    Tautology<Object> tautology = new Tautology<Object>();
    Object anyCandidate = new Object();

    @Test public void
    isAlwaysSatisfied() {
        assertThat("satisfied", tautology.isSatisfiedBy(anyCandidate), is(true));
    }
}
