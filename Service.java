import javafx.util.converter.LocalDateStringConverter;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class Service implements Runnable{

//    private Server server;
    private Socket socket;
    private BufferedReader lineReader;
    private PrintWriter replier;

    public Service(Socket socket){
//        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Service started!");
        try{
            lineReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            replier = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            while(true){
                String line = lineReader.readLine();
                if(line.equals("QUIT") || line == null){
                    replier.println("QUIT");
                    socket.close();
                }

                replier.println("OK");
                replier.println(this.getClass().toString());
            }
        }
        catch (IOException error){
            error.printStackTrace();
        }
        finally{
            socket.close();
        }
    }
}
