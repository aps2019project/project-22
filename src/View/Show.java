package View;

import Model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Random;
import java.util.Scanner;

public class Show {
    private static void collectionMenu(Scanner scanner, Account account) {
        String input = scanner.nextLine().trim();
        String[] partsOfInput = input.split("\\s+");
        if ("exit".equals(input)) {
            return;
        } else if ("show".equals(partsOfInput[0])) {
            if (partsOfInput.length == 1)
                Show.showCollection(account);
            else if (partsOfInput[1].equals("all") && partsOfInput[2].equals("decks")) {
                account.showAllDecks();
            } else if (partsOfInput[1].equals("deck")) {
                account.showDeckByName(partsOfInput[2]);
            }
        } else if (partsOfInput[0].equals("search")) {
            if (account.getCollection().search(partsOfInput[1]) != -1)
                System.out.println(account.getCollection().search(partsOfInput[1]));
            else
                System.out.println("not found...:[");
        } else if (partsOfInput.length == 3 && partsOfInput[0].equals("create") && partsOfInput[1].equals("deck")) {
            Deck.createDeck(partsOfInput[2], account);
        } else if (partsOfInput.length == 3 && partsOfInput[0].equals("delete") && partsOfInput[1].equals("deck")) {
            Deck.deleteDeck(partsOfInput[2], account);
        } else if ("save".equals(input)) {
            account.getCollection().save();
        } else if ("help".equals(input)) {
            Show.helpInCollection();
        } else if (partsOfInput.length == 5 && partsOfInput[0].equals("add") && partsOfInput[2].equals("to")
                && partsOfInput[3].equals("deck")) {
            try {
                Deck.searchDeckByName(partsOfInput[4]).addCard(Integer.parseInt(partsOfInput[1]), account);
            } catch (Exception name) {
                System.out.println("deckName is invalid");
            }
        } else if (partsOfInput[0].equals("validate") && partsOfInput[1].equals("deck")) {
            account.checkIsValidate(partsOfInput[2]);
        } else if (partsOfInput[0].equals("remove") && partsOfInput[2].equals("from") && partsOfInput[3].equals("deck")) {
            account.removeCardFromDeckByIdAndName(Integer.parseInt(partsOfInput[1]), partsOfInput[4]);
        } else if (partsOfInput[0].equals("select") && partsOfInput[1].equals("deck")) {
            account.setMainDeckByName(partsOfInput[2]);
        }
        collectionMenu(scanner, account);
    }

    public static void showMainMenuOfAccount(Scanner scanner, Account account, Group root) {
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
                showBattleMenu(account, battle, scanner, root);
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
            case "help":
                System.out.println("-Enter collection\n-Enter shop\n-Enter battle\n-Save\n-Logout");
                break;
        }
        showMainMenuOfAccount(scanner, account, root);
    }

    private static void showAllUserNames() {
        for (int i = 0; i < Account.getAccounts().size(); i++) {
            System.out.println((i + 1) + ".  " + Account.getAccounts().get(i).getUserName());
        }
    }


    private static void shopMenu(Scanner scanner, Account account) {
        String command = scanner.nextLine().trim();
        String[] partsOfCommand = command.split("\\s+");
        if (command.equals("show")) {
            Shop.showAllCardsAndItems();
        } else if (command.equals("exit") || command.equals("Exit")) {
            return;
        } else if (partsOfCommand[0].equals("show") && partsOfCommand[1].equals("collection")) {
            Show.showCollection(account);
        } else if (partsOfCommand[0].equals("search")) {
            if (partsOfCommand[1].equals("collection")) {
                if (account.getCollection().search(partsOfCommand[2]) != -1)
                    System.out.println(account.getCollection().search(partsOfCommand[2]));
                else
                    System.out.println("Not Found!");
            } else {
                if (Shop.searchByName(partsOfCommand[1]) != -1)
                    System.out.println("id = " + Shop.searchByName(partsOfCommand[1]));
                else
                    System.out.println("Not Found!");
            }
        } else if (partsOfCommand[0].equals("buy")) {
            Shop.buy(partsOfCommand[1], account);
        } else if (partsOfCommand[0].equals("sell")) {
            Shop.sell(Integer.parseInt(partsOfCommand[1]), account);
        } else if (partsOfCommand[0].equals("help") || partsOfCommand[0].equals("Help")) {
            System.out.println("-show\n-show collection\n-search [item name | card name]\n-search collection [item name |" +
                    " card name]\n-buy [card name | item name]\n-sell [card id | item id]\n-exit");
        }
        shopMenu(scanner, account);
    }

    public static void showCollection(Account account) {
        Collection collection = account.getCollection();
        int number = 1;
        System.out.println("Heroes :");
        for (int i = 0; i < collection.getHeroes().size(); i++) {
            System.out.println("\t" + number + " : Name : " + collection.getHeroes().get(i).getName() + " - AP : " +
                    collection.getHeroes().get(i).getAttackPower() + " - HP : " + collection.getHeroes().get(i).
                    getHealthPoint() + " - Class : " + collection.getHeroes().get(i).getTypeOfAttack() +
                    " - Special power: " + "attack" + " - price: " + collection.getHeroes().get(i).getPrice() + " Id= " +
                    collection.getHeroes().get(i).getId());
            number++;
        }
        number = 1;
        System.out.println("Items :");
        for (int i = 0; i < collection.getItems().size(); i++) {
            System.out.println("\t" + number + " : Name : " + collection.getItems().get(i).getName() + " Desc: " +
                    collection.getItems().get(i).getDescription() + " - price: " + collection.getItems().get(i).getPrice()
                    + " ID=" + collection.getItems().get(i).getId());
            number++;
        }
        number = 1;
        System.out.println("Cards :");
        for (int i = 0; i < collection.getSpells().size(); i++) {
            System.out.println("\t" + number + " : Type : Spell - Name : " + collection.getSpells().get(i).getName() +
                    " - MP : " + collection.getSpells().get(i).getManaPoint() + " - " +
                    collection.getSpells().get(i).getDescription() + " - price: " + collection.getSpells().get(i).getPrice()
                    + " ID= " + collection.getSpells().get(i).getId());
            number++;
        }
        for (int i = 0; i < collection.getMinions().size(); i++) {
            System.out.println("\t" + number + " : Type : Minion - Name : " + collection.getMinions().get(i).getName()
                    + " - Class: " + collection.getMinions().get(i).getTypeOfAttack() + " - AP : " + collection.
                    getMinions().get(i).getAttackPower() + " - HP : " + collection.getMinions().get(i).getHealthPoint()
                    + " - MP : " + collection.getMinions().get(i).getManaPoint() + " - Special power : " +
                    collection.getMinions().get(i).getSpecialPower() + " - price: " + collection.getMinions().get(i).getPrice()
                    + " ID= " + collection.getMinions().get(i).getId());
            number++;
        }
    }

    public static void helpInCollection() {
        System.out.println("-exit\n-show\n-search[card name | item name]\n-save\ncreate deck[deck name]\n-delete deck" +
                "[deck name]\n-add[card id | card id |hero id| to deck [deck name]\n-remove" +
                "[ card id|card id|hero id| lfrom deck[deck name]\n-validate deck[ deck name]\n-selsect deck" +
                " [ deck name]\n-show all decks\n-show deck [deck name]\n-help");
    }

    public static void showBattleMenu(Account account, Battle battle, Scanner scanner, Group root) {
        System.out.println("~~~BattleMenu~~~");
        System.out.println("choose opponent");
        showAllUserNames();
        int opponent = Integer.parseInt(scanner.nextLine());
        opponent--;
        MakeCell.make();
        MakeHero makeHero = new MakeHero();
        makeHero.make();
        MakeMinions makeMinions = new MakeMinions();
        makeMinions.make();
        MakeItems makeItems = new MakeItems();
        makeItems.make();
        MakeSpell makeSpell = new MakeSpell();
        makeSpell.make();
        Player player1 = new Player();
        Player player2 = new Player();
        player2.setAccount(Account.getAccounts().get(opponent));
        player1.setAccount(account);
        System.out.println("1. single player");
        System.out.println("2. multi player");
        System.out.println("3. exit");

        String input0 = scanner.nextLine();
        if (input0.equals("exit") || input0.equals("Exit") || input0.equals("3")) {
            return;
        }
        int singleOrMulti = Integer.parseInt(input0);

        System.out.println("1.Story");
        System.out.println("2.Custom game");
        System.out.println("3. exit");
        String numberOfInput = scanner.nextLine();

        if (numberOfInput.equals("exit") || numberOfInput.equals("3") || numberOfInput.equals("Exit"))
            return;
        int storyOrCustom = Integer.parseInt(numberOfInput);
        if (storyOrCustom == 1) {
            battle = new Story();
            battle.setStoryTrue();
            if (singleOrMulti == 1) {
                battle.setBooleanSinglePlayerTrue();
            }
            System.out.println("1. level1\n2. level2\n3. level3\n4. exit");
            String input2 = scanner.nextLine();
            if (input2.equals("4") || input2.equals("exit"))
                return;
            int level = Integer.parseInt(input2);
            if (level == 1) {
                ((Story) battle).setLevel(1);
                Random rand = new Random();
                int n = rand.nextInt(10) + 61;
                Card.searchCardByID(68).setX(1);
                Card.searchCardByID(68).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 1 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(62));
                    }
                }
                player1.setHero((Hero) Card.searchCardByID(68));
                player1.addCardsInTheFile(Card.searchCardByID(68));
                player1.addCardsInTheFile((Hero) Card.searchCardByID(68));
                Deck deckPlayer2 = new Deck("level1");
                deckPlayer2.setLevel1(deckPlayer2);
                player2.setMainDeck(deckPlayer2);
                player2.setHand();
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
                Deck deckPlayer1 = new Deck(player1.getAccount().getUserName());
                player1.setDeck(deckPlayer1);
                player1.setHand();
                battle.setPlayer1(player1);
                battle.setPlayer2(player2);
                battle.fight(account, scanner, root);
            } else if (level == 2) {
                ((Story) battle).setLevel(2);
                Random rand = new Random();
                int n = rand.nextInt(10) + 61;

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
                player2.setMainDeck(deckPlayer2);
                player2.setHand();
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
                Deck deckPlayer1 = new Deck(player1.getAccount().getUserName());
                player1.setDeck(deckPlayer1);
                player1.setHand();
                battle.setPlayer1(player1);
                battle.setPlayer2(player2);
                battle.fight(account, scanner, root);
            } else if (level == 3) {
                ((Story) battle).setLevel(3);
                battle.setHowManyFlags(7);
                Random rand = new Random();
                int n = rand.nextInt(10) + 61;

                Card.searchCardByID(68).setX(1);
                Card.searchCardByID(68).setY(3);

                for (int i = 0; i < Cell.getCells().size(); i++) {
                    if (Cell.getCells().get(i).getX() == 1 && Cell.getCells().get(i).getY() == 3) {
                        Cell.getCells().get(i).addCard(Card.searchCardByID(n));
                    }
                }
                player1.setHero((Hero) Card.searchCardByID(68));
                player1.addCardsInTheFile(Card.searchCardByID(62));
                Deck deckPlayer2 = new Deck("level3");
                deckPlayer2.setLevel3(deckPlayer2);
                player2.setMainDeck(deckPlayer2);

                player2.setHand();
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
                Deck deckPlayer1 = new Deck(player1.getAccount().getUserName());
                player1.setDeck(deckPlayer1);
                player1.setHand();
                battle.setPlayer1(player1);
                battle.setPlayer2(player2);
                battle.fight(account, scanner, root);
            } else if (level == 4) {
                return;
            }
        } else if (storyOrCustom == 2) {
            battle = new CustomGame();
            if (singleOrMulti == 1) {
                battle.setBooleanSinglePlayerTrue();
            }
            Random rand = new Random();
            int n = rand.nextInt(10) + 61;

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
            account.showAllDecks();
            System.out.println("1. mode1\n2. mode2\n3. mode3\n4. exit");
            String input3 = scanner.nextLine();
            if (input3.equals("4") || input3.equals("exit"))
                return;
            int num = Integer.parseInt(input3);
            if (num == 4)
                return;
            ((CustomGame) battle).setMode(num);
            String input = scanner.nextLine();
            ((CustomGame) battle).setCoustomGame(input);
            battle.fight(account, scanner, root);


        } else if (singleOrMulti == 3) {
            return;
        } else {
            showBattleMenu(account, battle, scanner, root);
        }
    }

    public static void showMainMenu(Scanner scanner, Group root) {
        Image image = new Image("File:menu.jpg");
        ImageView menu = new ImageView();
        menu.setImage(image);
        menu.setFitHeight(600);
        menu.setFitWidth(1000);

        Button btn1 = new Button("      Login        ");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn1.setPrefSize(600, 200);
        hbBtn1.setTranslateX(162);
        hbBtn1.setTranslateY(45);
        hbBtn1.getChildren().add(btn1);

        Image i1 = new Image("File:photos/buttonCreateAccount.png");
        ImageView buttonImage1 = new ImageView();
        buttonImage1.setImage(i1);
        buttonImage1.relocate(155, 162);
        buttonImage1.setFitWidth(140);
        buttonImage1.setFitHeight(35);

        Image i2 = new Image("file:button.png");
        ImageView buttonImage2 = new ImageView();
        buttonImage2.setImage(i2);
        buttonImage2.relocate(154, 215);
        buttonImage2.setFitWidth(145);
        buttonImage2.setFitHeight(40);

        Image i3 = new Image("file:photos/blueButton.png");
        ImageView buttonImage3 = new ImageView();
        buttonImage3.setImage(i3);
        buttonImage3.relocate(154, 258);
        buttonImage3.setFitWidth(145);
        buttonImage3.setFitHeight(40);


        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(menu, buttonImage1, buttonImage2,buttonImage3);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
//                System.out.println("x=\t" + x + "\ty=\t" + y);

                if (x > 154) {
                    if (x < 296 && y > 161 && y < 198) {
                        System.out.println("siiiiiiiiign up");
                    }
                    if (x < 300 && y > 214 && y < 256) {
                        Image image1 = new Image("File:loginpage.jpg");
                        menu.setImage(image1);
                        Platform.runLater(
                                new Runnable() {
                                    public void run() {
                                        root.getChildren().removeAll(hbBtn1, buttonImage1, buttonImage2,buttonImage3);
                                        loginPage(root, scanner);
                                    }
                                }
                        );
                    }
                    if (x < 300 && y > 262 && y < 294) {
                        System.out.println("loaderboard");
                    }
                }
            }
        });


        System.out.println("1. create account\n2. login\n3. show leaderboard\n4. help");
        System.out.println("\t*** please enter a number : ***");
        String input = scanner.nextLine().trim();
        String str[];
        if (input.equals("exit") || input.equals("Exit")) {
            SaveAccounts.save();
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
                    Show.showMainMenuOfAccount(scanner, Account.getAccountActivated(), root);
                }
            }
        } else if (input.equals("3") || input.equals("show leaderboard")) {
            Show.showLeaderBoard();
        } else if (input.equals("4") || input.equals("Help") || input.equals("help")) {
            System.out.println("-create account [user name]\n-login [username]\n-show leaderboard\n-exit");
        }
        showMainMenu(scanner, root);
    }

    private static void loginPage(Group root, Scanner scanner) {
        TextField userTextField = new TextField();
        userTextField.setTranslateY(270);
        userTextField.setTranslateX(500);
        PasswordField passwordField = new PasswordField();
        passwordField.setTranslateY(315);
        passwordField.setTranslateX(460);
        Button btn4 = new Button("   Login   ");
        HBox hbBtn4 = new HBox(10);
        hbBtn4.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn4.setTranslateY(365);
        hbBtn4.setTranslateX(455);
        hbBtn4.getChildren().add(btn4);

        final Text actiontarget = new Text();
        root.getChildren().addAll(userTextField, hbBtn4, passwordField, actiontarget);

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                String text = "";
                try {
                    if (Account.checkLogin(userTextField.getText(), passwordField.getText())) {
                        root.getChildren().removeAll(userTextField, hbBtn4, passwordField, actiontarget);
                        Show.showMainMenuOfAccount(scanner, Account.getAccountActivated(), root);
                    }
                } catch (Exception name) {
                }
                actiontarget.setText(text);
            }
        });
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
