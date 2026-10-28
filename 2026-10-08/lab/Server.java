package lab;
import java.io.*;
import java.net.*;

public class Server {
	private static final int PORT = 9090;

	public static void main(String... args) {
		TextService service = new BasicTextService();

		try {
			ServerSocket server = new ServerSocket(PORT);
			while (true) {
				System.out.println("Waiting for a client");
				Socket client = server.accept();
				new ClientHandler(client, service).start();
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}