package wordwrap;

public class WordWrap {
    public static String wrap(String text, int length) {
        if(text.length() > length) {
            return text.substring(0,1) + "\n" + text.substring(1);
        }
        return text;
    }
}
