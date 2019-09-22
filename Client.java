import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Client {

    private Socket socket;

    public Client() {

        connectToServer("localhost", 8888);
    }

    private void connectToServer(String address, int port){
        try{
            socket = new Socket(InetAddress.getByName(address), port);
        }
        catch(IOException error){
            error.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
