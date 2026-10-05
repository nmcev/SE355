import java.io.*;
import java.net.*;

public class Client {
    // a client sends a request to the server
    public static void main(String... args) {

        Socket socket = null;

        try {
            socket = new Socket("dict.org", 2628);

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF8");
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());

            // Writing Data
            writer.write("DEFINE english book \r\n"); // instructor: proper CRLF writer.flush();

            // Reading Data
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
            // out.write(255);
            // out.flush();

            // out.write(2);
            // out.flush(); // give it to tcp no cache

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
