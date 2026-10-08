import java.net.*;
import java.io.*;

public class Client2 {
    
    public static void main(String[] args)  throws Exception{
        

        Socket server = new Socket("127.0.0.1", 8080);
        ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());


        SayByeRequest req = new SayByeRequest();
        oos.writeObject(req);
        oos.flush();
    }
}
