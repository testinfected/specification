package test.org.testinfected.specification;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testinfected.specification.Contradiction;
import org.testinfected.specification.Specification;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JMock.class)
public class ContradictionTest {

    Mockery context = new JUnit4Mockery();

    Contradiction<Object> contradiction = Contradiction.none();
    Object anyCandidate = new Object();
    Contradiction<Object> itself = Contradiction.none();

    Specification<?> moreSpecific = context.mock(Specification.class, "moreSpecific");
    Specification<?> moreGeneric = context.mock(Specification.class, "moreGeneric");

    @Test public void
    isNeverSatisfied() {
        assertThat("satisfied by any", contradiction.isSatisfiedBy(anyCandidate), is(false));
    }

    @Test public void
    isSpecialCaseOfAllOtherSpecifications() {
        givenGeneralization(moreGeneric);
        givenSpecialization(moreSpecific);

        assertThat("special case of more generic", contradiction.isSpecialCaseOf(moreGeneric), is(true));
        assertThat("special case of more specific", contradiction.isSpecialCaseOf(moreSpecific), is(true));
    }

    @Test public void
    isOnlyMoreGenericThanSpecialCaseSpecifications() {
        givenSpecialization(moreSpecific);
        givenGeneralization(moreGeneric);

        assertThat("generalization of more specific", contradiction.isGeneralizationOf(moreSpecific), is(true));
        assertThat("generalization of self", contradiction.isGeneralizationOf(itself), is(true));
        assertThat("generalization of more generic", contradiction.isGeneralizationOf(moreGeneric), is(false));
//        assertThat("special case of leaf", tautology.isSpecialCaseOfLeaf(leafSpecification), is(false));
    }

    private void givenSpecialization(final Specification<?> specification) {
        context.checking(new Expectations() {{
            allowing(specification).isSpecialCaseOf(contradiction); will(returnValue(true));
        }});
    }

    private void givenGeneralization(final Specification<?> specification) {
        context.checking(new Expectations() {{
            allowing(specification).isGeneralizationOf(contradiction); will(returnValue(false));
        }});
    }
}
