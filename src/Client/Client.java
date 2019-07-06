package Client;

import Model.*;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Formatter;

public class Client {
    private static ArrayList<Client> clients = new ArrayList<>();
    private Account account;
    private Thread clientThread;
    private Socket socket;
    private Formatter formatter;
    private Scanner scanner;

    public Client(Socket socket) {
        this.setSocket(socket);
        clients.add(this);
        try {
            formatter = new Formatter(socket.getOutputStream());
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public Thread getClientThread() {
        return clientThread;
    }

    public void setClientThread(Thread clientThread) {
        this.clientThread = clientThread;
    }
}