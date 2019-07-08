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
    public static ArrayList<String> online = new ArrayList<>();
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
                online.add("online");
                wins.add((int)inputStream.readObject());
                while (true){
                    try {
                        String in = (String)inputStream.readObject();
                        if (in.matches("show all clients")){
                            outputStream.writeObject(accounts);
                        }else if (in.matches("shopping")){
                            String work = (String)inputStream.readObject();
                            String name = (String)inputStream.readObject();
                            if (Cards.valid(name,work)){
                                outputStream.writeObject(1);
                                outputStream.flush();
                                System.out.println("i send the massege too");
                            }else {
                                outputStream.writeObject(0);
                                outputStream.flush();
                            }
                        }
                    }catch (Exception e){
                        e.toString();
                    }

                }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
