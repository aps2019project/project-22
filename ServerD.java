import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerD extends Thread {
    public static ArrayList<Socket> connections = new ArrayList<>();
    public static ArrayList<String> accounts = new ArrayList<>();
    public static ArrayList<Integer> wins = new ArrayList<>();
    public static Object lock;
    Socket socket ;
    public ServerD(Socket s){
        socket = s;
    }
    public void run(){
        try {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                connections.add(socket);
                accounts.add((String)inputStream.readObject());
                wins.add((int)inputStream.readObject());
                while (true){
                    try {
                        String in = (String)inputStream.readObject();
                        if (in.matches("show all clients")){
                            outputStream.writeObject(accounts);
                        }
                    }catch (Exception e){}

                }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
