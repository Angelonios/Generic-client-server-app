import java.net.Socket;

public class Service implements Runnable{

    private Socket socket;

    public Service(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Service started!");
    }
}
