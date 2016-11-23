package wordwrap;

public class WordWrap {
    public static String wrap(String text, int length) {
        if(text.length() > length) {
            int indexOfFirstSpace = text.indexOf(" ");
            if(indexOfFirstSpace == -1) {
                indexOfFirstSpace = length;
            }

            return text.substring(0, indexOfFirstSpace).trim() + "\n" +
                    wrap(text.substring(indexOfFirstSpace).trim(),length);
        }
        return text;
    }
}
