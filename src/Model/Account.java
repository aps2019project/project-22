package Model;

import View.Show;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Account {

    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Account accountActivated;
    private Collection collection = new Collection();
    private String password;
    private int ID;
    private String userName;
    private int money;
    private int wins = 0;
    private int loses = 0;
    private boolean logIn;
    private static final int firstMoney = 15000;
    private Player player = new Player();
    private ArrayList<MatchHistory> matchHistory = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private Deck mainDeck;
    private int story;
    private static int count = 0;

    public static void addNewAccount(Account account) {
        accounts.add(account);
    }

    public String showAllDecks() {
        String string = "";
        for (int i = 0; i < decks.size(); i++) {
            string += showDeckByIndex(i) + "\n";
        }
        return string;
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

    public static Account searchByUserName(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(username))
                return accounts.get(i);
        }
        return null;
    }

    public static void createAccount(String username, Scanner scanner) {
        Account account = searchByUserName(username);
        if (account != null) {
            Show.accountIsAvailableNow();
        } else {
            String password = Show.getPassword(scanner);
            Account newAccount = new Account(username, password);
            Account.addNewAccount(newAccount);
        }
    }

    public static String signUp(String username, String pw, String rpw) {
        Account account = searchByUserName(username);
        if (account != null || username.isEmpty()) {
            return "Ooops! that username is unavailable! Try again.";
        } else {
            if (pw.isEmpty())
                return "Please enter your password.";
            if (!pw.equals(rpw))
                return "Not match! Please re-enter your password.";
            Account newAccount = new Account(username, pw);
            Account.addNewAccount(newAccount);
            return "welcome " + username;
        }
    }

    public static String checking(String userName, String password) {
        if (searchByUserName(userName) == null) {
            return "Invalid Username!";
        }
        if (!searchByUserName(userName).getPassword().equals(password)) {
            return "Incorrect Password! Try Again.";
        }
        Account.accountActivated = searchByUserName(userName);
        return "welcome";
    }

    public static void sortAll() {
        for (int i = 0; i < accounts.size() - 1; i++) {

            for (int j = 0; j < accounts.size() - 1 - i; j++) {
                if (accounts.get(j + 1).getWins() > accounts.get(j).getWins())
                    Collections.swap(accounts, j, j + 1);
            }
        }
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

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
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

    public static boolean checkLogin(String userName, String password) {
        if (searchByUserName(userName) == null) {
            Show.invalidUserName();
            return false;
        }
        if (!searchByUserName(userName).getPassword().equals(password)) {
            Show.incorrectPassword();
            return false;
        }
        Account.accountActivated = searchByUserName(userName);
        return true;
    }

    public void increaseMoney(int price) {
        this.money += price;
    }

    public void decreaseMoney(int price) {
        this.money -= price;
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
                    if (accounts.get(i).getLoses() < accounts.get(j).getLoses())
                        Account.swap(i, j);
            }
    }

    private static void swap(int i, int j) {
        Collections.swap(Account.getAccounts(), i, j);
    }

    public String showDeckByName(String name) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(name)) {
                return showDeckByIndex(i);
            }
        }
        return ("Not Found!\n");
    }

    private String showDeckByIndex(int i) {
        String string = "";
        string += ((i + 1) + " : " + decks.get(i).getName() + " :\n\tHeroes :\n");

        if (decks.get(i).getHero() != null) {
            string += ("\t\t1 : Name : " + decks.get(i).getHero().getName() +
                    " - AP: " + decks.get(i).getHero().getAttackPower() + " - HP : " + decks.get(i).getHero().getHealthPoint()
                    + " - ID : " + decks.get(i).getHero().getId() + " Type of attack: " + decks.get(i).getHero().getTypeOfAttack() + "\n");
        }
        string += ("\tItems :\n");
        if (decks.get(i).getItem() != null) {
            string += ("\t\t1 : Name : " + decks.get(i).getItem().getName() + " - Desc : " + decks.get(i).getItem().getDescription() + "\n");
        }
        string += ("\tCards:\n");
        for (int j = 0; j < decks.get(i).getCardsOfDeck().size(); j++) {
            string += ("\t\t" + (j + 1) + " : Type: " + printTypeOfCard(decks.get(i).getCardsOfDeck().get(j).getType()) +
                    " - Name : " + decks.get(i).getCardsOfDeck().get(j).getName() + " - Id : " + decks.get(i).getCardsOfDeck().get(j).getId() + "\n");
        }
        return string;
    }

    private String printTypeOfCard(int type) {//0 hero | 1 spell | 2 minion
        switch (type) {
            case 0:
                return "Hero";
            case 1:
                return "Spell";
            case 2:
                return "Minion";
            default:
                return "";
        }
    }

    public String checkIsValidate(String deckName) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(deckName)) {
                if (decks.get(i).getCardsOfDeck().size() == 20 && decks.get(i).getHero() != null) {
                    return ("deck is valid:)!");
                } else {
                    return ("deck is invalid!:(");
                }
            }
        }
        return "Invalid DeckName";
    }

    public String removeCardFromDeckByIdAndName(int id, String nameOfDeck) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(nameOfDeck)) {
                if (decks.get(i).getHero() != null && decks.get(i).getHero().getId() == id) {
                    decks.get(i).setHero(null);
                    return ("hero removed.");
                }
                if (decks.get(i).getItem() != null && decks.get(i).getItem().getId() == id) {
                    decks.get(i).setItem(null);
                    return ("item removed.");
                }
                for (int j = 0; j < decks.get(i).getCardsOfDeck().size(); j++) {
                    if (decks.get(i).getCardsOfDeck().get(j).getId() == id) {
                        decks.get(i).getCardsOfDeck().remove(j);
                        return ("card removed.");
                    }
                }
                return "Removed";
            }
        }
        return ("Invalid Deck Name.\nPlease Try Again.");
    }

    public Deck searchDeckByName(String nameOfDeck) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(nameOfDeck)) {
                return decks.get(i);
            }
        }
        return null;
    }

    public String setMainDeckByName(String name) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(name)) {
                if (decks.get(i).getCardsOfDeck().size() == 20 && decks.get(i).getHero() != null) {
                    setMainDeck(decks.get(i));
                    return "Selected.";
                } else {
                    return ("this deck is invalid!");
                }
            }
        }
        return "Invalid DeckName.\nPlease Try Again.";
    }

    public void deleteDeck(int i) {
        decks.remove(i);
    }
}