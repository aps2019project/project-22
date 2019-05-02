package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Account {

    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Account accountActivated;
    private Collection collection = new Collection();
    private String password;
    private int ID;
    private boolean logIn;
    private static final long firstMoney = 15000;
    private long money;
    private int wins;
    private int looses;
    private Player player = new Player();
    private ArrayList<MatchHistory> matchHistory = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private String userName;
    private Deck mainDeck;
    private int story;
    private static int count = 0;

    public static void addNewAccount(String userName, String password) {
        if (!booleanSearchByUserName(userName)) {
            Account account = new Account(userName, password);
            account.setPassword(password);
            account.setUserName(userName);
            accounts.add(account);
            return;

        } else if (booleanSearchByUserName(userName)) {
            System.out.println("Enter another username");
            return;
        } else if (booleanSearchByPassword(password)) {
            System.out.println("Enter another password");
        }
    }


    public Account(String userName, String password) {
        this.setWins(0);
        this.setStory(0);
        this.setMoney(Account.firstMoney);
        this.matchHistory = new ArrayList<MatchHistory>();
        this.collection = new Collection();
        this.setUserName(userName);
        this.setPassword(password);
        this.setID(Account.count++);

    }
    public Account(){

    }

    public static boolean booleanSearchByUserName(String userName) {
        for (Account account : Account.getAccounts()) {
            if (account.getUserName().compareTo(userName) == 0)
                return true;
        }
        return false;
    }

    public static boolean booleanSearchByPassword(String password) {
        for (Account account : Account.getAccounts()) {
            if (account.getPassword().compareTo(password) == 0)
                return true;
        }
        return false;
    }

    public static boolean booleanSearchByID(int ID) {
        for (Account account : Account.getAccounts()) {
            if (account.getID() == ID)
                return true;
        }
        return false;
    }

    public static boolean booleanSearchByAccount(Account account1) {
        for (Account account : Account.getAccounts()) {
            if (account == account1)
                return true;
        }
        return false;
    }

    public static Account SearchByUserName(String userName) {
        for (Account account : Account.getAccounts()) {
            if (account.getUserName().compareTo(userName) == 0)
                return account;
        }
        return null;
    }

    public static Account SearchById(int ID) {
        for (Account account : Account.getAccounts()) {
            if (account.getID() == ID)
                return account;
        }
        return null;
    }

    public boolean checkIfPasswordIsCorrect(String password) {

        if (this.password.equals(password)) return true;
        return false;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        Account.accounts = accounts;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Account.count = count;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLooses() {
        return looses;
    }

    public void setLooses(int looses) {
        this.looses = looses;
    }


    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public ArrayList<MatchHistory> getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(ArrayList<MatchHistory> matchHistory) {
        this.matchHistory = matchHistory;
    }


    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public boolean getLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public static Account getAccountActivated() {
        return accountActivated;
    }

    public static void setAccountActivated(Account accountActivated) {
        Account.accountActivated = accountActivated;
    }

    public void chooseMainDeck() {
        Random rand = new Random();
        int index = rand.nextInt(20);
        this.setMainDeck(decks.get(index));

    }

    public void changeMainDeck(Deck deck) {
        this.mainDeck = deck;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public static void deleteAccount(Account account) {
        accounts.remove(account);
    }

    public static void checkLogin(String userName, String password) {
        Account account = new Account(userName, password);
        if (!account.getPassword().equals(password)) {
            System.out.println("Invalid password or username");
            return;
        }
        Account.accountActivated = account;
    }


    public void increaseMoney(int increase) {
        this.money += increase;
    }

    public void decreaseMoney(int decrease) {
        this.money -= decrease;
    }


    public void addDeck(Deck deck) {
        this.getDecks().add(deck);
    }

    public void removeDeck(Deck deck) {
        this.getDecks().remove(deck);
    }


    private static void sortAccounts() {
        for (int i = 0; i < Account.getAccounts().size(); i++)
            for (int j = i + 1; j < Account.getAccounts().size(); j++) {
                if (accounts.get(i).getWins() > accounts.get(j).getWins()) {
                    Account.swap(i, j);
                }
                if (accounts.get(i).getWins() == accounts.get(j).getWins())
                    if (accounts.get(i).getLooses() < accounts.get(j).getLooses())
                        Account.swap(i, j);
            }
    }

    private static void swap(int i, int j) {
        Collections.swap(Account.getAccounts(), i, j);
    }


}