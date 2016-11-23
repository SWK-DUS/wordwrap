package wordwrap;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static wordwrap.WordWrap.wrap;

public class WordWrapTest {

    /*
        "Four score and seven years ago our fathers brought forth upon this continent"

        wrapped at 7

        "Four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"
     */

    @Test
    public void empty(){
        assertWrapped("", 0, "");
        assertWrapped("", 1, "");
    }

    @Test
    public void singleCharacter_wrappedAtOne_returnsSameString() {
        assertWrapped("a", 1, "a");
    }

    @Test
    public void twoCharacterString_WrappedAtOne_ReturnsHardWrappedString() {
        assertWrapped("ab",1,"a\nb");
    }

    @Test
    public void twoCharacterString_wrappedAtTwo_returnsSameString(){
        assertWrapped("ab", 2, "ab");
    }

    @Test
    public void threeCharacterString_wrappedAtTwo_returnsStringWithHardWrap() {
        assertWrapped("abc", 2, "ab\nc");
    }

    private void assertWrapped(String input, int wrapAt, String wrappedText) {
        assertThat(wrap(input, wrapAt), equalTo(wrappedText));
    }
}
