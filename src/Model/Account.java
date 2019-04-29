package Model;

import java.util.ArrayList;
import java.util.Random;

public class Account {
    private ArrayList<Collection> collections;
    private String password;
    private boolean logIn;
    private long money = 15000;
    private static ArrayList<Account> accounts;
    private ArrayList<MatchHistory> matchHistory;
    private ArrayList<Deck> decks;
    private String userName;
    private Deck mainDeck;

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public ArrayList<MatchHistory> getMatches() {
        return matchHistory;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public long getMoney() {
        return money;
    }

    public ArrayList<Collection> getCollections() {
        return collections;
    }

    public static void addNewAccount(String password, String userName) {
        Account account = new Account();
        account.setPassword(password);
        account.setUserName(userName);
        accounts.add(account);
    }

    public static void deleteAccount(Account account) {
        accounts.remove(account);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean getLogIn() {
        return logIn;
    }

    public void changeMainDeck(Deck deck) {


    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void chooseMainDeck() {
        Random rand = new Random();
        int index = rand.nextInt(20);
        this.setMainDeck(decks.get(index));

    }
}