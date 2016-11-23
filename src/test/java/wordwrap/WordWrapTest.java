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
    public void emptyString_isReturnedAsItIs(){
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

    @Test
    public void threeCharacters_wrappedAtThree_returnsSameString() {
        assertWrapped("abc", 3, "abc");
    }


    @Test
    public void fourCharacters_wrappedAtTwo_returnsHardWrappedString() {
        assertWrapped("abcd", 2, "ab\ncd");
    }

    @Test
    public void threeCharacters_wrappedAtOne_returns3HardWrappedStrings() {
        assertWrapped("abc", 1, "a\nb\nc");
    }

    @Test
    public void sevenCharacters_wrappedAtTwo_returns4HardWrappedStrings() {
        assertWrapped("abcdefg", 2, "ab\ncd\nef\ng");
    }

    @Test
    public void twoCharactersWithSpace_wrappedAtOne_returnsTwoWrappedCharacters(){
        assertWrapped("a b", 1, "a\nb");
    }

    @Test
    public void twoCharactersWithSpace_wrappedAtTwo_returnsTwoWrappedCharacters(){
        assertWrapped("a b", 2, "a\nb");
    }

    @Test
    public void threeCharacters_withSpaceAfterFirst_wrappedAtThree_wrapsAtSpace() {
        assertWrapped("a bc", 3, "a\nbc");
    }

    @Test
    public void fourCharacters_withSpaceAfterSecond_wrappedAtFour_wrapsAtSpace() {
        assertWrapped("ab cd", 4, "ab\ncd");
    }

    @Test
    public void fiveCharacterWithTwoSpaces_wrappedAtFour_wrapesAtSecondSpace() {
        assertWrapped("a b c", 4, "a b\nc");
    }

    @Test
    public void fiveCharactersWithSpaces_wrappedAtFive_wrapsAtLastSpaceBeforeLength() {
        assertWrapped("a b c d e", 5, "a b c\nd e");
    }

    @Test
    public void acceptanceTest() {
        assertWrapped(
                "Four score and seven years ago our fathers brought forth upon this continent",
                7,
                "Four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt");
    }

    private void assertWrapped(String input, int wrapAt, String wrappedText) {
        assertThat(wrap(input, wrapAt), equalTo(wrappedText));
    }
}
