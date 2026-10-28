package lab;
import java.io.Serializable;
import java.util.Date;

public class ParagraphRequest implements Serializable {

	public String paragraph;
	public Date sentAt;

	public ParagraphRequest(String paragraph, Date sentAt) {
		this.paragraph = paragraph;
		this.sentAt = sentAt;
	}
}