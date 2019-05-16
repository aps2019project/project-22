package View;

import Model.*;

import java.util.Random;
import java.util.Scanner;

public class Show {
    private static void collectionMenu(Scanner scanner, Account account) {
        String input = scanner.nextLine().trim();
        String[] partsOfInput = input.split("\\s+");
        if ("exit".equals(input)) {
            return;
        } else if ("show".equals(input)) {
            Show.showCollection(account);
        } else if (partsOfInput[0].equals("search")) {
            if (account.getCollection().search(partsOfInput[1]) != -1)
                System.out.println(account.getCollection().search(partsOfInput[1]));
            else
                System.out.println("not found...:[");
        } else if (partsOfInput.length == 3 && partsOfInput[0].equals("create") && partsOfInput[1].equals("deck")) {
            Deck.createDeck(partsOfInput[2]);
        } else if (partsOfInput.length == 3 && partsOfInput[0].equals("delete") && partsOfInput[1].equals("deck")) {
            Deck.deleteDeck(partsOfInput[2]);
        } else if ("save".equals(input)) {
            account.getCollection().save();
        } else if ("help".equals(input)) {
            Show.helpInCollection();
        } else if (partsOfInput.length == 5 && partsOfInput[0].equals("add") && partsOfInput[2].equals("to")
                && partsOfInput[3].equals("deck")) {
            Deck.searchDeckByName(partsOfInput[4]).addCard(Integer.parseInt(partsOfInput[1]), account);
        }
    }

    public static void showMainMenuOfAccount(Scanner scanner, Account account) {
        System.out.println("1. Collection\n2. Shop\n3. Battle\n4. Exit\n5. Save\n6 .Logout\n7. Help");
        String input = scanner.nextLine().trim();
        switch (input) {
            case "Enter collection":
                collectionMenu(scanner, account);
                break;
            case "Enter shop":
                shopMenu(scanner, account);
                break;
            case "Enter battle":
                Battle battle = new Battle();
                showBattleMenu(battle, scanner);
                break;
            case "Save":
                //save
                break;
            case "Logout":
                return;
            case "Exit":
                return;
            case "Help":
                System.out.println("-Enter collection\n-Enter shop\n-Enter battle\n-Save\n-Logout");
                break;
        }
        showMainMenuOfAccount(scanner, account);
    }

    private static void showAllUserNames() {
        for (int i = 0; i < Account.getAccounts().size(); i++) {
            System.out.println((i + 1) + ".  " + Account.getAccounts().get(i).getUserName());
        }
    }


    private static void shopMenu(Scanner scanner, Account account) {
        String command = scanner.nextLine().trim();
        if(command.equals("show")){
            Shop.showAllCardsAndItems();
        }
    }

    public static void showCollection(Account account) {
        Collection collection = account.getCollection();
        int number = 1;
        System.out.println("Heroes :");
        for (int i = 0; i < collection.getHeroes().size(); i++) {
            System.out.println("\t" + number + " : Name : " + collection.getHeroes().get(i).getName() + " - AP : " +
                    collection.getHeroes().get(i).getAttackPower() + " - HP : " + collection.getHeroes().get(i).
                    getHealthPoint() + " - Class : " + collection.getHeroes().get(i).getTypeOfAttack() +
                    " - Special power: " + "attack" + " - price: " + collection.getHeroes().get(i).getPrice());
            //attack nmidunm jash chie!
            number++;
        }
        number = 1;
        System.out.println("Items :");
        for (int i = 0; i < collection.getItems().size(); i++) {
            System.out.println("\t" + number + " : Name : " + collection.getItems().get(i).getName() + " Desc: " +
                    collection.getItems().get(i).getDescription() + " - price: " + collection.getItems().get(i).getPrice());
            number++;
        }
        number = 1;
        System.out.println("Cards :");
        for (int i = 0; i < collection.getSpells().size(); i++) {
            System.out.println("\t" + number + " : Type : Spell - Name : " + collection.getSpells().get(i).getName() +
                    " - MP : " + collection.getSpells().get(i).getManaPoint() + " - " +
                    collection.getSpells().get(i).getDescription() + " - price: " + collection.getSpells().get(i).getPrice());
            number++;
        }
        for (int i = 0; i < collection.getMinions().size(); i++) {
            System.out.println("\t" + number + " : Type : Minion - Name : " + collection.getMinions().get(i).getName()
                    + " - Class: " + collection.getMinions().get(i).getTypeOfAttack() + " - AP : " + collection.
                    getMinions().get(i).getAttackPower() + " - HP : " + collection.getMinions().get(i).getHealthPoint()
                    + " - MP : " + collection.getMinions().get(i).getManaPoint() + " - Special power : " +
                    collection.getMinions().get(i).getSpecialPower() + " - price: " + collection.getMinions().get(i).getPrice());
            number++;
        }
    }

    public static void helpInCollection() {
        System.out.println("-exit\n-show\n-search[card name | item name]\n-save\ncreate deck[deck name]\n-delete deck" +
                "[deck name]\n-add[card id | card id |hero id| to deck [deck name]\n-remove" +
                "[ card id|card id|hero id| lfrom deck[deck name]\n-validate deck[ deck name]\n-selsect deck" +
                " [ deck name]\n-show all decks\n-show deck [deck name]\n-help");
    }

    public static void showBattleMenu(Battle battle, Scanner scanner) {
        System.out.println("~~~~~");
        MakeCell.make();
        MakeHero makeHero = new MakeHero();
        makeHero.make();
        MakeMinions makeMinions = new MakeMinions();
        makeMinions.make();
        MakeItems makeItems = new MakeItems();
        makeItems.make();
        MakeSpell makeSpell = new MakeSpell();
        makeSpell.make();
        System.out.println("1.single player");
        System.out.println("2.multi player");

        int singleOrMulti = scanner.nextInt();
        if (singleOrMulti == 1) {
            battle.setBooleanSinglePlayerTrue();
        }
        System.out.println("1.Story");
        System.out.println("2.Custom game");
        int storyOrCustom = scanner.nextInt();
        if (storyOrCustom == 1) {
            battle = new Story();
            battle.setStoryTrue();
            System.out.println("1. level1\n2. level2\n3. level3");
            int level = scanner.nextInt();
            if (level == 1) {
                ((Story) battle).setLevel(1);
                Random rand = new Random();
                int n = rand.nextInt(10) + 61;
                Player player1 = new Player();
                Card.searchCardByID(62).setX(1);
                Card.searchCardByID(62).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 1 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(62));
                    }
                }
                player1.setHero((Hero) Card.searchCardByID(62));
                player1.addCardsInTheFile(Card.searchCardByID(62));
                player1.addCardsInTheFile((Hero) Card.searchCardByID(62));
                Deck deckPlayer2 = new Deck("level1");
                deckPlayer2.setLevel1(deckPlayer2);
                Player player2 = new Player();
                player2.setMainDeck(deckPlayer2);
                player2.setHero((Hero) Card.searchCardByID(61));
                player2.addCardsInTheFile(Card.searchCardByID(61));
                Card.searchCardByID(61).setX(9);
                Card.searchCardByID(61).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 9 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(61));
                    }
                }
                player1.setCard();
                Deck deckPlayer1 = new Deck("player1");
                player1.setDeck(deckPlayer1);
                player1.setHand();
                battle.setPlayer1(player1);
                battle.setPlayer2(player2);
                battle.fight(scanner);
            } else if (level == 2) {
                ((Story) battle).setLevel(2);
                Random rand = new Random();
                int n = rand.nextInt(10) + 61;
                Player player1 = new Player();

                Card.searchCardByID(62).setX(1);
                Card.searchCardByID(62).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 1 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(62));
                    }
                }

                player1.setHero((Hero) Card.searchCardByID(62));
                player1.addCardsInTheFile(Card.searchCardByID(62));
                Deck deckPlayer2 = new Deck("level2");
                deckPlayer2.setLevel2(deckPlayer2);
                Player player2 = new Player();
                player2.setMainDeck(deckPlayer2);

                Card.searchCardByID(65).setX(9);
                Card.searchCardByID(65).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 9 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(65));
                    }
                }

                player2.setHero((Hero) Card.searchCardByID(65));
                player2.addCardsInTheFile(Card.searchCardByID(65));
                player1.setCard();
                Deck deckPlayer1 = new Deck("player1");
                player1.setDeck(deckPlayer1);
                player1.setHand();
                battle.setPlayer1(player1);
                battle.setPlayer2(player2);
                battle.fight(scanner);
            } else if (level == 3) {
                ((Story) battle).setLevel(3);
                battle.setHowManyFlags(7);
                Random rand = new Random();
                int n = rand.nextInt(10) + 61;
                Player player1 = new Player();

                Card.searchCardByID(n).setX(1);
                Card.searchCardByID(n).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 1 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(n));
                    }
                }
                player1.setHero((Hero) Card.searchCardByID(n));
                player1.addCardsInTheFile(Card.searchCardByID(n));
                Deck deckPlayer2 = new Deck("level3");
                deckPlayer2.setLevel3(deckPlayer2);
                Player player2 = new Player();
                player2.setMainDeck(deckPlayer2);

                Card.searchCardByID(67).setX(9);
                Card.searchCardByID(67).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 9 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(67));
                    }
                }
                player2.setHero((Hero) Card.searchCardByID(67));
                player2.addCardsInTheFile(Card.searchCardByID(67));
                player1.setCard();
                Deck deckPlayer1 = new Deck("player1");
                player1.setDeck(deckPlayer1);
                player1.setHand();
                battle.setPlayer1(player1);
                battle.setPlayer2(player2);
                battle.fight(scanner);
            }
        } else if (storyOrCustom == 2) {
            battle = new CustomGame();
            Deck.showDecks();
            System.out.println("1. mode1\n2. mode2\n3. mode3");
            ((CustomGame) battle).setMode(scanner.nextInt());
            String input = scanner.nextLine();
            ((CustomGame) battle).setCoustomGame(input);

            Random rand = new Random();
            int n = rand.nextInt(10) + 61;
            Player player1 = new Player();

            Card.searchCardByID(62).setX(1);
            Card.searchCardByID(62).setY(3);

            for (int i = 0; i < Cell.getCells().size(); i++) {
                if (Cell.getCells().get(i).getX() == 1 && Cell.getCells().get(i).getY() == 3) {
                    Cell.getCells().get(i).addCard(Card.searchCardByID(62));
                }
            }
            player1.setHero((Hero) Card.searchCardByID(62));
            player1.addCardsInTheFile(Card.searchCardByID(62));
            Deck deckPlayer2 = new Deck("player2");
            Player player2 = new Player();
            player2.setCard();
            player2.setDeck(deckPlayer2);
            player2.setHand();
            player2.setMainDeck(deckPlayer2);
            int n2 = rand.nextInt(10) + 61;
            Card.searchCardByID(n2).setX(9);
            Card.searchCardByID(n2).setY(3);

            for (int i = 0; i < Cell.getCells().size(); i++) {
                if (Cell.getCells().get(i).getX() == 9 && Cell.getCells().get(i).getY() == 3) {
                    Cell.getCells().get(i).addCard(Card.searchCardByID(n2));
                }
            }
            player2.setHero((Hero) Card.searchCardByID(n2));
            player2.addCardsInTheFile(Card.searchCardByID(n));
            player1.setCard();
            Deck deckPlayer1 = new Deck("player1");
            player1.setDeck(deckPlayer1);
            player1.setHand();
            battle.setPlayer1(player1);
            battle.setPlayer2(player2);
            battle.fight(scanner);
        }
        else{
            showBattleMenu(battle,scanner);
        }
    }

    public static void showMainMenu(Scanner scanner) {
        System.out.println("1. create account [user name]\n2. login [username]\n3. show leaderboard\n4. help");
        System.out.println("\t*** please enter a number : ***");
        String input = scanner.nextLine().trim();
        String str[];
        if (input.equals("exit") || input.equals("Exit")) {
            return;
        } else if (input.equals("1") || input.equals("create account")) {
            input = scanner.nextLine().trim();
            str = input.split("\\s+");
            if (str.length == 3 && str[0].equals("create") && str[1].equals("account")) {
                Account.createAccount(str[2], scanner);
            }
        } else if (input.equals("2") || input.equals("login")) {
            System.out.println("please enter your username by -login [username]-");
            input = scanner.nextLine().trim();
            str = input.split("\\s+");
            if (str.length == 2 && str[0].equals("login")) {
                System.out.println("please enter your password.:)");
                String password = scanner.nextLine();
                if (Account.checkLogin(str[1], password)) {
                    Show.showMainMenuOfAccount(scanner, Account.getAccountActivated());
                }
            }
        } else if (input.equals("3") || input.equals("show leaderboard")) {
            Show.showLeaderBoard();
        }
        showMainMenu(scanner);
        return;
    }

    private static void showLeaderBoard() {
        Account.sortAll();
        for (int i = 0; i < Account.getAccounts().size(); i++) {
            System.out.println((i + 1) + " - UserName : " + Account.getAccounts().get(i).getUserName() + "\t-\tWins : "
                    + Account.getAccounts().get(i).getWins());
        }
    }

    public static void accountIsAvailableNow() {
        System.out.println("Account Is Available Now! =)");
    }

    public static String getPassword(Scanner scanner) {
        System.out.println("please enter password");
        return scanner.nextLine();
    }

    public static void invalidUserName() {
        System.out.println("invalid username!!");
    }

    public static void incorrectPassword() {
        System.out.println("The password is incorrect");
    }
}
