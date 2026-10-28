package lab;
import java.io.Serializable;
import java.util.Date;

public class ParagraphResponse implements Serializable {

	public String paragraph;
	public Date sentAt;

	public ParagraphResponse(String paragraph, Date sentAt) {
		this.paragraph = paragraph;
		this.sentAt = sentAt;
	}
}