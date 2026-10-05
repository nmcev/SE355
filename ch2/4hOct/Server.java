import java.io.*;
import java.net.*;

/**
 * SErer
 */
public class Server {
    public static void main(String[] args) {

        try {
            // single client
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                Socket client = server.accept();

                ClientHandler handler = new ClientHandler(client);

                // handler.run();

                handler.start();

            }


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

}

/**
 * InnerServer
 */
class ClientHandler extends Thread {

    private Socket socket;

    public ClientHandler(Socket connection) {
        this.socket = connection;

    }

    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out, "UTF8");

            for (int i = 0; i < 5000; i++) {
                writer.write("Hello SE355 \n");
                writer.flush();

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}