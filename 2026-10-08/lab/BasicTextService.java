package lab;

public class BasicTextService implements TextService {

    public String capitalizeWords(String text) {
        StringBuilder result = new StringBuilder(text.length());
        boolean startOfWord = true;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isWhitespace(c)) {
                startOfWord = true;
                result.append(c);
            } else if (startOfWord) {
                result.append(Character.toUpperCase(c));
                startOfWord = false;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
