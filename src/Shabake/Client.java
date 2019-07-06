package Shabake;

import Model.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Formatter;

public class Client {

    private static ArrayList<Client> clients = new ArrayList<>();
    private static DataInputStream input = null;
    private static DataOutputStream out = null;
    private static Socket socket;
    private Account account;
    private Thread clientThread;
    private Formatter formatter;
    private Scanner scanner;

    public Client(Socket socket) {
        this.setSocket(socket);
        System.out.println("Connected");
        clients.add(this);
        try {
            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
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

    public static void main(String[] args) {
        String line = "";

        while (!line.equals("End")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}