package wordwrap;

public class WordWrap {
    public static String wrap(String text, int length) {
        if(text.length() > length) {
            return text.substring(0,length) + "\n" + text.substring(length);
        }
        return text;
    }
}
