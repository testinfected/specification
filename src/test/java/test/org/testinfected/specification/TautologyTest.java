package test.org.testinfected.specification;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testinfected.specification.Specification;
import org.testinfected.specification.Tautology;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JMock.class)
public class TautologyTest {

    Mockery context = new JUnit4Mockery();

    Tautology<Object> tautology = Tautology.any();
    Object anyCandidate = new Object();
    Tautology<Object> itself = Tautology.any();
    Tautology<Object> leafSpecification = Tautology.any();

    Specification<?> moreSpecific = context.mock(Specification.class, "moreSpecific");
    Specification<?> moreGeneric = context.mock(Specification.class, "moreGeneric");
    
    @Test public void
    isAlwaysSatisfied() {
        assertThat("satisfied by any", tautology.isSatisfiedBy(anyCandidate), is(true));
    }

    @Test public void
    isGeneralizationOfAllOtherSpecifications() {
        givenSpecialization(moreSpecific);
        givenGeneralization(moreGeneric);

        assertThat("generalization of more specific", tautology.isGeneralizationOf(moreSpecific), is(true));
        assertThat("generalization of more generic", tautology.isGeneralizationOf(moreGeneric), is(true));
    }

    @Test public void
    isNeverMoreSpecificThanAnySpecification() {
        givenGeneralization(moreGeneric);
        givenSpecialization(moreSpecific);

        assertThat("special case of more generic", tautology.isSpecialCaseOf(moreGeneric), is(false));
        assertThat("special case of self", tautology.isSpecialCaseOf(itself), is(true));
        assertThat("special case of more specific", tautology.isSpecialCaseOf(moreSpecific), is(false));
//        assertThat("special case of leaf", tautology.isSpecialCaseOfLeaf(leafSpecification), is(false));
    }

    private void givenSpecialization(final Specification<?> specification) {
        context.checking(new Expectations() {{
            allowing(specification).isSpecialCaseOf(tautology); will(returnValue(true));
            allowing(specification).isGeneralizationOf(tautology); will(returnValue(true));
        }});
    }

    private void givenGeneralization(final Specification<?> specification) {
        context.checking(new Expectations() {{
            allowing(specification).isGeneralizationOf(tautology); will(returnValue(true));
            allowing(specification).isSpecialCaseOf(tautology); will(returnValue(false));
        }});
    }
}
