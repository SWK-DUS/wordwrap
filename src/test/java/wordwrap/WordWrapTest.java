package wordwrap;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class WordWrapTest {

    /*
        "Four score and seven years ago our fathers brought forth upon this continent"

        wrapped at 7

        "Four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"
     */

    @Test
    public void empty(){
        assertThat(WordWrap.wrap("",0),equalTo(""));
        assertThat(WordWrap.wrap("",1),equalTo(""));
    }

    @Test
    public void singleCharacter_wrappedAtOne_returnsSameString() {
        assertThat(WordWrap.wrap("a", 1), equalTo("a"));
    }
}
