package lab;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Client1 {
	static String HOST = "127.0.0.1";
	static int PORT = 9090;

	private static String readParagraph() throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder paragraph = new StringBuilder();

		System.out.println("Type a paragraph (finish with an empty line):");
		String line;
		while ((line = keyboard.readLine()) != null && !line.isEmpty()) {
			if (paragraph.length() > 0) {
				paragraph.append('\n');
			}
			paragraph.append(line);
		}
		return paragraph.toString();
	}

	public static void main(String... args) {
		try {
			String paragraph = readParagraph();

			Socket toServer = new Socket(HOST, PORT);
			ObjectOutputStream out = new ObjectOutputStream(toServer.getOutputStream());
			out.flush();
			ObjectInputStream in = new ObjectInputStream(toServer.getInputStream());

			out.writeObject(new ParagraphRequest(paragraph, new Date()));
			out.flush();

			ParagraphResponse response = (ParagraphResponse) in.readObject();
			System.out.println("Server replied at " + response.sentAt + ":");
			System.out.println(response.paragraph);

			toServer.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}