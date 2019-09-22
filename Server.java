import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket servicePort;

    private ExecutorService pool;

    public Server(int port){
        pool = Executors.newFixedThreadPool(10);
        listen(port);
    }

    private void listen(int port) {
        try{
            servicePort = new ServerSocket(port);
            while(true){
                process(servicePort.accept());
            }
        }
        catch(IOException error){
            error.printStackTrace();
        }
    }

    private void process(Socket socket) {
        pool.execute(new Service(socket));
    }

    public static void main(String[] args) {
        Server s = new Server(8888);
    }
}
