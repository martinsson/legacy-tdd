package matchers.dojo;

import static java.util.Arrays.asList;
import static matchers.dojo.CheatSheet.CollectionOfSize.ofSize;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;


public class CheatSheet {
    final static class CollectionOfSize extends TypeSafeDiagnosingMatcher<Collection<String>> {
        private final Matcher<? super Integer> matcher;

        private CollectionOfSize(Matcher<? super Integer> matcher) {
            this.matcher = matcher;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("a Collection of size ").appendDescriptionOf(matcher);
        }

        @Override
        protected boolean matchesSafely(Collection<String> item, Description mismatchDescription) {
            if (matcher.matches(item.size())) {
                return true;
            } else {
                mismatchDescription.appendText("a Collection of ").appendValue(item.size()).appendText(" elements");
                return false;
            }
                
        }

        @Factory
        public static Matcher<Collection<String>> ofSize(final Matcher<? super Integer> matcher) {
            return new CollectionOfSize(matcher);
        }
    }

    @Test
    public void returnsFalseWhenTheUnderLyingMatcherReturnsFalse() throws Exception {
        List<String> names = asList("Myrtille", "Rose");
        Matcher<Collection<String>> ofSize = ofSize(equalTo(3));
        assertThat(ofSize.matches(names), is(false));
    }

    @Test
    public void returnsTrueWhenTheUnderLyingMatcherReturnsTrue() throws Exception {
        List<String> names = asList("Myrtille", "Rose", "Camille");
        Matcher<Collection<String>> ofSize = ofSize(equalTo(3));
        assertThat(ofSize.matches(names), is(true));
    }
    
    @Test
    public void describesTheExpectedCondition() throws Exception {
        StringDescription description = new StringDescription();
        ofSize(equalTo(2)).describeTo(description);
        Description desc2 = new StringDescription();
        equalTo(2).describeTo(desc2 );
        assertThat(description.toString(), equalTo("a Collection of size " + desc2 ));
    }
    
    @Test
    public void describesWhyTheMatchWasntPossible() throws Exception {
        List<String> names = asList("Myrtille", "Rose", "Camille", "Bernard");
        StringDescription description = new StringDescription();
        ofSize(equalTo(2)).describeMismatch(names, description);
        assertThat(description.toString(), startsWith("a Collection of <"+names.size()+"> elements"));
    }

}
