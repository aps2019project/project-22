package Model;

public class Account {
    private Arraylist<Collection> collections;
    private String password;
    private boolean logIn;
    private long money;
    private static Arraylist<Account> accounts;
    private Arraylist<MatchHistory> matchHistory;
    private ArraylistDeck>decks;
    private String userName;
    private Deck mainDeck;

    public Arraylist<Match> getMatches() {
        return matches;
    }

    public Arraylist<Deck> getDecks() {
        return decks;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public static Arraylist<Account> getAccounts() {
        return accounts;
    }

    public long getMoney() {
        return money;
    }

    public Arraylist<Collection> getCollections() {
        return collections;
    }

    public static addNewAccount(String password, String userName) {

    }

    public static deleteAccount(Account account) {

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean getLogIn() {
        return LogIn;
    }

    public void changeMainDeck(Deck deck) {

    }

    public void setPassword(String password) {

    }

    public void setUserName(String userName) {

    }
}