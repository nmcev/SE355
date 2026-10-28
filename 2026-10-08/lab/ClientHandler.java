package lab;
import java.io.*;
import java.net.*;
import java.util.Date;

public class ClientHandler extends Thread {

	private final Socket socket;
	private final TextService service;

	public ClientHandler(Socket socket, TextService service) {
		this.socket = socket;
		this.service = service;
	}

	
	public void run() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			ParagraphRequest request = (ParagraphRequest) in.readObject();
			System.out.println("Received request sent at " + request.sentAt);

			String modified = service.capitalizeWords(request.paragraph);
			out.writeObject(new ParagraphResponse(modified, new Date()));
			out.flush();

		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			try {
				socket.close();
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}