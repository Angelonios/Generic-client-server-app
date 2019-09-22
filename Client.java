import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class Client {

    private static final Logger logger = Logger.getLogger(Client.class.getName());

    private Socket socket;



    public Client() throws IOException {
        connectToServer("localhost", 8888);
    }

    private void connectToServer(String address, int port) throws IOException{
        socket = new Socket(InetAddress.getByName(address), port);
    }


}
