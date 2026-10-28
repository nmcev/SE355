package lab;
/** Business logic contract; keeps the Server loosely coupled to the implementation. */
public interface TextService {
	String capitalizeWords(String text);
}