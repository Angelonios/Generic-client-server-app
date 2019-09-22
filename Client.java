import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    private InetAddress serverAddress;
    private int serverPort;

    public Client(String address, int port) throws UnknownHostException {
        serverAddress = InetAddress.getByName(address);
        serverPort = port;
    }
}
