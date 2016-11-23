package wordwrap;

public class WordWrap {
    public static String wrap(String text, int length) {
        if (text.length() <= length) {
            return text;
        }

        int indexOfLastSpace = text.lastIndexOf(" ", length);
        if(indexOfLastSpace == -1) {
            indexOfLastSpace = length;
        }

        return text.substring(0, indexOfLastSpace).trim() + "\n" +
                wrap(text.substring(indexOfLastSpace).trim(),length);
    }
}
