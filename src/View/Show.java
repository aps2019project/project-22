package View;

import Model.*;
import Presenter.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Image image = new Image("File:menu.jpg");
        ImageView menu = new ImageView();
        menu.setImage(image);
        menu.setFitHeight(600);
        menu.setFitWidth(1000);

        Image i1 = new Image("file:photos/blueButton.png");
        Image i2 = new Image("file:button.png");

        ImageView buttonImage = new ImageView();
        buttonImage.setImage(i1);
        buttonImage.relocate(155, 162);
        buttonImage.setFitWidth(145);
        buttonImage.setFitHeight(40);

        ImageView buttonImage1 = new ImageView();
        buttonImage1.setImage(i1);
        buttonImage1.relocate(155, 165);
        buttonImage1.setFitWidth(145);
        buttonImage1.setFitHeight(40);

        Label label1 = new Label("Collection");
        label1.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label1.relocate(193, 177);
        label1.setTextFill(Color.WHITESMOKE);

        ImageView buttonImage2 = new ImageView();
        buttonImage2.setImage(i2);
        buttonImage2.relocate(154, 215);
        buttonImage2.setFitWidth(145);
        buttonImage2.setFitHeight(40);

        Label label2 = new Label("Shop");
        label2.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label2.relocate(205, 225);
        label2.setTextFill(Color.WHITESMOKE);

        ImageView buttonImage3 = new ImageView();
        buttonImage3.setImage(i1);
        buttonImage3.relocate(154, 258);
        buttonImage3.setFitWidth(145);
        buttonImage3.setFitHeight(40);

        Label label3 = new Label(" Battle");
        label3.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label3.relocate(196, 269);
        label3.setTextFill(Color.WHITESMOKE);

        ImageView buttonImage4 = new ImageView();
        buttonImage4.setImage(i2);
        buttonImage4.relocate(154, 301);
        buttonImage4.setFitWidth(145);
        buttonImage4.setFitHeight(40);

        Label label4 = new Label(" Save");
        label4.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label4.relocate(197, 312);
        label4.setTextFill(Color.WHITESMOKE);

        ImageView buttonImage5 = new ImageView();
        buttonImage5.setImage(i1);
        buttonImage5.relocate(154, 344);
        buttonImage5.setFitWidth(145);
        buttonImage5.setFitHeight(40);

        Label label5 = new Label(" Custom Card");
        label5.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label5.relocate(178, 354);
        label5.setTextFill(Color.WHITESMOKE);

        ImageView buttonImage6 = new ImageView();
        buttonImage6.setImage(i2);
        buttonImage6.relocate(154, 387);
        buttonImage6.setFitWidth(145);
        buttonImage6.setFitHeight(40);

        Label label6 = new Label("Logout");
        label6.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label6.relocate(197, 397);
        label6.setTextFill(Color.WHITESMOKE);

        ImageView exitButton = new ImageView();
        buttonImage1.setImage(new Image("file:photos/exitButton.png"));
        buttonImage1.relocate(27, 508);
        buttonImage1.setFitWidth(80);
        buttonImage1.setFitHeight(80);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(menu, buttonImage, buttonImage1, label1, buttonImage2,
                                label2, buttonImage3, label3, buttonImage4, label4, buttonImage5,
                                label5, buttonImage6, label6, exitButton);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // save
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                if (x > 154) {
                                    root.getChildren().clear();
                                    if (x < 296 && y > 161 && y < 198) {
                                        root.getChildren().clear();
                                        collectionMenu(scanner, account);
                                        return;
                                    }
                                    if (x < 300 && y > 214 && y < 256) {
                                        root.getChildren().clear();
                                        shopMenu(scanner, account);
                                        return;
                                    }
                                    if (x < 300 && y > 262 && y < 294) {
                                        root.getChildren().clear();
                                        Battle battle = new Battle();
                                        showBattleMenu(account, battle, scanner, root, "Choose Opponent");
                                        return;
                                    }
                                    if (x < 300 && y > 298 && y < 330) {
                                        SaveAccounts.save();
                                        root.getChildren().clear();
                                        showMainMenu(scanner, root);
                                        return;
                                    }
                                    if (x > 169 && x < 289 && y >= 350 && y < 382) {
                                        root.getChildren().clear();
                                        showCreateCustomCard(root);
                                        return;
                                    }
                                    if (x > 169 && x < 284 && y > 390 && y < 424) {
                                        root.getChildren().clear();
                                        showMainMenu(scanner, root);
                                        return;
                                    }
                                } else if (x > 26 && x < 108 && y > 507 && y < 589) {
                                    root.getChildren().clear();
                                    showExitPage(root);
                                    return;
                                }
                            }
                        });
            }
        });
    }

    private static void showCreateCustomCard(Group root) {


        Image image = new Image("File:photos/bg0.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);
        root.getChildren().add(imageView);

        Label[] labels = new Label[22];
        for (int i = 0; i < 22; i++) {
            labels[i] = new Label();
            labels[i].setFont(Font.font("Verdana", FontWeight.BOLD, 15));
            labels[i].setTextFill(Color.SKYBLUE);
            labels[i].relocate(120, 5 + 25 * i);
            root.getChildren().add(labels[i]);
        }
        labels[0].setText("Name");
        labels[1].setText("Cost");
        labels[2].setText("Type(spell 0,minion 1,hero 2)");
        labels[3].setText("Target For Spell");
        labels[4].setText("AP");
        labels[5].setText("HP");
        labels[6].setText("Attack Type(melee,ranged,hybrid)");
        labels[7].setText("Range Of Attack");
        labels[8].setText("Special Power Activation");
        labels[9].setText("Special Power Cooldown");

        // buff
        labels[11].setText("Name Of Buff");
        labels[12].setText("Buff Type");
        labels[13].setText("Effect Value");
        labels[14].setText("Delay");
        labels[15].setText("Last");
        labels[16].setText("Friend 0 Or Enemy 1");
        for (int i = 11; i < 17; i++) {
            labels[i].setTranslateY(labels[i].getTranslateY() - 20);
            labels[i].setTextFill(Color.BLUEVIOLET);
        }

        //spell
        labels[18].setText("Name Of Spell");
        labels[19].setText("ID");
        labels[20].setText("Mana");
        labels[21].setText("Description");

        for (int i = 18; i < 22; i++) {
            labels[i].setTranslateY(labels[i].getTranslateY() - 41);
            labels[i].setTextFill(Color.MEDIUMVIOLETRED);
        }

        TextField[] textFields = new TextField[20];
        for (int i = 0; i < 20; i++) {
            textFields[i] = new TextField();
            textFields[i].setPrefWidth(100);
            textFields[i].setMaxHeight(15);
            textFields[i].relocate(10, 25 * i);
            root.getChildren().add(textFields[i]);
        }
        for (int i = 10; i < 16; i++) {
            textFields[i].setTranslateY(textFields[i].getTranslateY() + 4);
        }
        for (int i = 16; i < 20; i++) {
            textFields[i].setTranslateY(textFields[i].getTranslateY() + 8);
        }

        ImageView button = new ImageView();
        button.setImage(new Image("File:photos/blueButton.png"));
        button.relocate(430, 520);
        button.setFitHeight(60);
        button.setFitWidth(165);

        Label label = new Label();
        label.setText("Create");
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        label.relocate(485, 540);

        root.getChildren().addAll(button, label);

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                try {
                    if (x > 450 && x < 578 && y > 530 && y < 575) {
                        Spell spell = new Spell(Integer.parseInt(textFields[17].getText()), textFields[16].getText(),
                                Integer.parseInt(textFields[1].getText()), Integer.parseInt(textFields[18].getText()),
                                textFields[3].getText(), textFields[19].getText());

                        Buff buff = new Buff(textFields[10].getText(), textFields[12].getText(), Integer.parseInt(
                                textFields[14].getText()), textFields[11].getText(),
                                Integer.parseInt(textFields[13].getText()), Integer.parseInt(textFields[15].getText())) {
                            @Override
                            public void applyBuff(Spell spellCard) {
                                this.setSpellCard(spell);
                            }
                        };
                        CustomCard customCard = new CustomCard(textFields[0].getText(), Integer.parseInt(textFields[2].getText()),
                                textFields[3].getText(), buff, Integer.parseInt(textFields[4].getText()), Integer.parseInt(textFields[5].getText()),
                                textFields[6].getText(), Integer.parseInt(textFields[7].getText()), textFields[9].getText(),
                                textFields[8].getText(), Integer.parseInt(textFields[1].getText()), spell);
                        Account.getAccountActivated().getCollection().addCustomCards(customCard);
                        popUpWindow("Custom Card Is Created. :)", 300, 150);
                    }
                } catch (Exception n) {
                    popUpWindow("invalid inputs", 300, 150);
                }
            }
        });

//
//        Button btn = new Button("PLAY");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        hbBtn.setTranslateX(10);
//        hbBtn.setTranslateY(290);
//
//        root.getChildren().addAll( numberTextField, hbBtn);

//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent e) {
//                Pattern pattern = Pattern.compile("\\d+");
//                Matcher matcher = pattern.matcher(numberTextField.getText());
//                if (!matcher.find() || Integer.parseInt(numberTextField.getText()) > Account.getAccounts().size()) {
//                    showBattleMenu(account, battle, scanner, root, "Please Enter A Number.");
//                    return;
//                }
//                int opponent = Integer.parseInt(numberTextField.getText());
//                opponent--;
//                MakeCell.make();
//                MakeHero makeHero = new MakeHero();
//                makeHero.make();
//                MakeMinions makeMinions = new MakeMinions();
//                makeMinions.make();
//                MakeItems makeItems = new MakeItems();
//                makeItems.make();
//                MakeSpell makeSpell = new MakeSpell();
//                makeSpell.make();
//                Player player1 = new Player();
//                Player player2 = new Player();
//                player2.setAccount(Account.getAccounts().get(opponent));
//                player1.setAccount(account);
//                root.getChildren().clear();
//                selectGamePage(root,  account, battle, player1, player2);
//            }
//        });
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

    public static void showBattleMenu(Account account, Battle battle, Scanner scanner, Group root, String command) {

        Image image = new Image("File:photos/opponents.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);
        root.getChildren().add(imageView);

        for (int i = 0; i < Account.getAccounts().size(); i++) {
            Label username = new Label();
            username.setText(i + 1 + ".\tUsername: " + Account.getAccounts().get(i).getUserName());
            username.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
            username.setTextFill(Color.BLUEVIOLET);
            username.relocate(100, 95 + 30 * i);
            root.getChildren().addAll(username);
        }

        Label label = new Label(command);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        label.setTextFill(Color.BLACK);
        label.relocate(10, 240);

        TextField numberTextField = new TextField();
        numberTextField.setPrefWidth(40);
        numberTextField.relocate(10, 260);

        Button btn = new Button("PLAY");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        hbBtn.setTranslateX(10);
        hbBtn.setTranslateY(290);

        root.getChildren().addAll(label, numberTextField, hbBtn);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(numberTextField.getText());
                if (!matcher.find() || Integer.parseInt(numberTextField.getText()) > Account.getAccounts().size()) {
                    showBattleMenu(account, battle, scanner, root, "Please Enter A Number.");
                    return;
                }
                int opponent = Integer.parseInt(numberTextField.getText());
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
                root.getChildren().clear();
                selectGamePage(root, account, battle, player1, player2);
            }
        });
    }

    private static void playGame(int storyCustom, int singleMulti, Account account, Battle battle
            , Group root, Player player1, Player player2,
                                 int levelOfGame) //akharesh bara custom esme deck mikhad! commente  va bayad benevisim.
    {

        int singleOrMulti = singleMulti;
        int storyOrCustom = storyCustom;

        if (storyOrCustom == 1) {
            battle = new Story();
            battle.setStoryTrue();
            if (singleOrMulti == 1) {
                battle.setBooleanSinglePlayerTrue();
            }
            int level = levelOfGame;
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
                battle.fight(account, root);
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
                battle.fight(account, root);
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
                battle.fight(account, root);
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
            int num = levelOfGame;
            ((CustomGame) battle).setMode(num);
            System.out.println("there there albalu");
//            String input = scanner.nextLine(); bayad biad esme deck bede!
            String input = "deck name player1"; // avaz she!
            ((CustomGame) battle).setCoustomGame(input);
            battle.fight(account, root);
        }
    }

    private static void selectGamePage(Group root, Account account, Battle battle, Player
            player1, Player player2) {
        Image image = new Image("File:photos/exit.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);

        Image i1 = new Image("File:button.png");
        ImageView o1 = new ImageView();
        o1.setImage(i1);
        o1.relocate(240, 400);
        o1.setFitHeight(40);
        o1.setFitWidth(150);

        Label text1 = new Label("Single Player");
        text1.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text1.setTextFill(Color.WHITESMOKE);
        text1.relocate(255, 410);

        Image i2 = new Image("File:photos/blueButton.png");
        ImageView o2 = new ImageView();
        o2.setImage(i2);
        o2.relocate(630, 400);
        o2.setFitHeight(40);
        o2.setFitWidth(150);

        Label text2 = new Label("Multi Player");
        text2.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text2.setTextFill(Color.WHITESMOKE);
        text2.relocate(665, 410);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(imageView, o1, o2, text1, text2);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                if (x > 256 && x < 374 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    selectMode(root, account, battle, player1, player2, 1);
                                }
                                if (x > 645 && x < 766 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    selectMode(root, account, battle, player1, player2, 2);
                                }
                            }
                        }
                );
            }
        });
    }

    private static void selectMode(Group root, Account account, Battle battle,
                                   Player player1, Player player2, int singleMulti) {
        Image image = new Image("File:photos/exit.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);

        Image i1 = new Image("File:button.png");
        ImageView o1 = new ImageView();
        o1.setImage(i1);
        o1.relocate(240, 400);
        o1.setFitHeight(40);
        o1.setFitWidth(150);

        Label text1 = new Label("Story");
        text1.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text1.setTextFill(Color.WHITESMOKE);
        text1.relocate(270, 410);

        Image i2 = new Image("File:photos/blueButton.png");
        ImageView o2 = new ImageView();
        o2.setImage(i2);
        o2.relocate(630, 400);
        o2.setFitHeight(40);
        o2.setFitWidth(150);

        Label text2 = new Label("Custom Game");
        text2.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text2.setTextFill(Color.WHITESMOKE);
        text2.relocate(665, 410);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(imageView, o1, o2, text1, text2);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                if (x > 256 && x < 374 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    selectLevel(root, account, battle, player1, player2, singleMulti, 1);
                                }
                                if (x > 645 && x < 766 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    selectLevel(root, account, battle, player1, player2, singleMulti, 2);
                                }
                            }
                        }
                );
            }
        });
    }

    private static void selectLevel(Group root, Account account, Battle battle,
                                    Player player1, Player player2, int singleMulti, int storyCustom) {
        String[] texts = new String[3];
        if (storyCustom == 1) {
            texts[0] = "Level 1";
            texts[1] = "Level 2";
            texts[2] = "Level 3";
        } else {
            texts[0] = "Mode 1";
            texts[1] = "Mode 2";
            texts[2] = "Mode 3";
        }

        Image image = new Image("File:photos/exit.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);

        Image i1 = new Image("File:button.png");
        ImageView o1 = new ImageView();
        o1.setImage(i1);
        o1.relocate(240, 400);
        o1.setFitHeight(40);
        o1.setFitWidth(150);

        Label text1 = new Label(texts[0]);
        text1.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text1.setTextFill(Color.WHITESMOKE);
        text1.relocate(270, 410);

        Image i2 = new Image("File:photos/blueButton.png");
        ImageView o2 = new ImageView();
        o2.setImage(i2);
        o2.relocate(435, 400);
        o2.setFitHeight(40);
        o2.setFitWidth(150);

        Label text2 = new Label(texts[1]);
        text2.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text2.setTextFill(Color.WHITESMOKE);
        text2.relocate(465, 410);

        Image i3 = new Image("File:photos/grayButton.png");
        ImageView o3 = new ImageView();
        o3.setImage(i3);
        o3.relocate(630, 400);
        o3.setFitHeight(40);
        o3.setFitWidth(150);

        Label text3 = new Label(texts[2]);
        text3.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text3.setTextFill(Color.WHITESMOKE);
        text3.relocate(665, 410);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(imageView, o1, o2, o3, text1, text2, text3);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                System.out.println("x= " + x + "\t\ty= " + y);
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                if (x > 256 && x < 374 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    root.getChildren().clear();
                                    playGame(1, singleMulti, account, battle, root, player1, player2, 1);
                                }
                                if (x > 440 && x < 560 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    root.getChildren().clear();
                                    playGame(2, singleMulti, account, battle, root, player1, player2, 2);
                                }
                                if (x > 645 && x < 766 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    playGame(2, singleMulti, account, battle, root, player1, player2, 3);

                                }

                            }
                        }
                );
            }
        });
    }

    public static void showMainMenu(Scanner scanner, Group root) {

        Image image = new Image("File:menu.jpg");
        ImageView menu = new ImageView();
        menu.setImage(image);
        menu.setFitHeight(600);
        menu.setFitWidth(1000);

        Image i1 = new Image("file:photos/greenButton.png");
        ImageView buttonImage1 = new ImageView();
        buttonImage1.setImage(i1);
        buttonImage1.relocate(154, 162);
        buttonImage1.setFitWidth(140);
        buttonImage1.setFitHeight(35);

        Label label1 = new Label("Create Account");
        label1.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label1.relocate(173, 181);
        label1.setTextFill(Color.WHITESMOKE);


        Image i2 = new Image("file:button.png");
        ImageView buttonImage2 = new ImageView();
        buttonImage2.setImage(i2);
        buttonImage2.relocate(154, 215);
        buttonImage2.setFitWidth(145);
        buttonImage2.setFitHeight(40);

        Label label2 = new Label("Login");
        label2.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label2.relocate(205, 225);
        label2.setTextFill(Color.WHITESMOKE);

        Image i3 = new Image("file:photos/blueButton.png");
        ImageView buttonImage3 = new ImageView();
        buttonImage3.setImage(i3);
        buttonImage3.relocate(154, 258);
        buttonImage3.setFitWidth(145);
        buttonImage3.setFitHeight(40);

        Label label3 = new Label("Leaderboard");
        label3.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label3.relocate(184, 269);
        label3.setTextFill(Color.WHITESMOKE);

        Image i4 = new Image("file:photos/yellowButton.png");
        ImageView buttonImage4 = new ImageView();
        buttonImage4.setImage(i4);
        buttonImage4.relocate(154, 300);
        buttonImage4.setFitWidth(146);
        buttonImage4.setFitHeight(45);

        Label label4 = new Label("  Save  ");
        label4.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label4.relocate(198, 310);
        label4.setTextFill(Color.WHITESMOKE);

        Image i = new Image("file:photos/greenButton.png");
        ImageView buttonImage = new ImageView();
        buttonImage.setImage(i);
        buttonImage.relocate(150, 170);
        buttonImage.setFitWidth(160);
        buttonImage.setFitHeight(45);

        ImageView exitButton = new ImageView();
        buttonImage1.setImage(new Image("file:photos/exitButton.png"));
        buttonImage1.relocate(25, 509);
        buttonImage1.setFitWidth(80);
        buttonImage1.setFitHeight(80);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(menu, buttonImage, buttonImage1, label1, buttonImage2, label2,
                                buttonImage3, label3, buttonImage4, label4, exitButton);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                if (x > 154) {
                                    if (x < 296 && y > 161 && y < 198) {
                                        root.getChildren().clear();
                                        signUpPage(root, scanner);
                                        return;
                                    }
                                    if (x < 300 && y > 214 && y < 256) {
                                        root.getChildren().clear();
                                        loginPage(root, scanner);
                                        return;
                                    }
                                    if (x < 300 && y > 262 && y < 294) {
                                        root.getChildren().clear();
                                        boardPage(root, scanner);
                                        return;
                                    }
                                    if (x > 174 && x < 285 && y < 333 && y > 308) {
                                        SaveAccounts.save();
                                    }
                                } else if (x > 26 && x < 108 && y > 507 && y < 589) {
                                    root.getChildren().clear();
                                    showExitPage(root);
                                }
                            }
                        });
            }
        });
    }

    private static void showExitPage(Group root) {
        Image image = new Image("File:photos/exit.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(imageView);
                        try {
                            root.getChildren().addAll(imageView);
                            Thread.sleep(5000);
                            Main.primaryStage.close();
                        } catch (Exception e) {
                        }
                    }
                }
        );
    }

    private static void boardPage(Group root, Scanner scanner) {
        Image image = new Image("File:photos/boardPage.jpg");
        ImageView board = new ImageView();
        board.setImage(image);
        board.setFitHeight(600);
        board.setFitWidth(1000);

        Text sceneTitle = new Text("Ranking");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        sceneTitle.setFill(Color.MEDIUMSLATEBLUE);
        sceneTitle.relocate(160, 110);

        Line underline = new Line(158, 135, 253, 135);
        underline.setFill(Color.BLACK);

        Image b = new Image("File:photos/backInBoard.png");
        ImageView back = new ImageView();
        back.setImage(b);
        back.relocate(920, 515);
        back.setFitWidth(70);
        back.setFitHeight(70);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(board, sceneTitle, back, underline);
                    }
                }
        );
        Account.sortAll();

        for (int i = 0; i < Account.getAccounts().size(); i++) {
            Label username = new Label();
            username.setText(i + 1 + ".\tUsername: " + Account.getAccounts().get(i).getUserName());
            username.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            username.setTextFill(Color.DEEPPINK);
            username.relocate(250, 150 + 40 * i);

            Label wins = new Label();
            wins.setText("Wins: " + Account.getAccounts().get(i).getWins());
            wins.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            wins.setTextFill(Color.DEEPPINK);
            wins.relocate(575, 150 + 40 * i);

            root.getChildren().addAll(username, wins);
        }

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                if (x > 931 && x < 985 && y > 524 && y < 577) {
                    root.getChildren().clear();
                    showMainMenu(scanner, root);
                }
            }
        });
    }

    private static void signUpPage(Group root, Scanner scanner) {
        Image image = new Image("File:photos/signUpPage.jpg");
        ImageView menu = new ImageView();
        menu.setImage(image);
        menu.setFitHeight(600);
        menu.setFitWidth(1000);

        Label userName = new Label("UserName");
        userName.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        userName.setTextFill(Color.WHITE);
        userName.relocate(182, 230);

        TextField userTextField = new TextField();
        userTextField.setPrefWidth(140);
        userTextField.relocate(190, 254);

        Label labelPw1 = new Label("Password");
        labelPw1.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        labelPw1.setTextFill(Color.WHITE);
        labelPw1.relocate(182, 290);

        PasswordField passwordField1 = new PasswordField();
        passwordField1.setPrefWidth(140);
        passwordField1.relocate(190, 314);

        Label labelPw2 = new Label("Enter Again");
        labelPw2.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        labelPw2.setTextFill(Color.WHITE);
        labelPw2.relocate(182, 349);

        PasswordField passwordField2 = new PasswordField();
        passwordField2.setPrefWidth(140);
        passwordField2.relocate(190, 373);


        Image i = new Image("File:photos/blueButton.png");
        ImageView buttonForCreateAccount = new ImageView();
        buttonForCreateAccount.setImage(i);
        buttonForCreateAccount.relocate(195, 413);
        buttonForCreateAccount.setFitWidth(140);
        buttonForCreateAccount.setFitHeight(40);

        Image b = new Image("File:photos/pinkButton.png");
        ImageView back = new ImageView();
        back.setImage(b);
        back.relocate(880, 495);
        back.setFitWidth(120);
        back.setFitHeight(120);

        Label label = new Label("Sign Up");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label.setTextFill(Color.LIGHTPINK);
        label.relocate(235, 425);

        Label command = new Label();
        command.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 13));
        command.setTextFill(Color.BLACK);
        command.relocate(218, 400);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(menu, userName, userTextField, passwordField1, passwordField2, labelPw1,
                                labelPw2, buttonForCreateAccount, back, label, command);
                    }
                }
        );


        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                if (x > 210 && x < 322 && y > 420 && y < 449) {
                                    String cm = Account.signUp(userTextField.getText(), passwordField1.getText(), passwordField2.getText());
                                    command.setText(cm);
                                    if (cm.contains("welcome")) {
                                        root.getChildren().clear();
                                        showMainMenu(scanner, root);
                                    }
                                }
                                if (x > 918 && x < 968 && y > 530 && y < 580)
                                    showMainMenu(scanner, root);
                            }
                        });
            }
        });
    }

    private static void popUpWindow(String message, int width, int height) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Main.primaryStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(message));
        Scene dialogScene = new Scene(dialogVbox, width, height);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public static void loginPage(Group root, Scanner scanner) {

        Image image = new Image("File:loginpage.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);

        TextField userTextField = new TextField();
        userTextField.relocate(377, 267);
        userTextField.setPrefSize(240, 34);

        PasswordField passwordField = new PasswordField();
        passwordField.relocate(377, 310);
        passwordField.setPrefSize(240, 33);

        Image i = new Image("file:photos/blueButton.png");
        ImageView buttonImage = new ImageView();
        buttonImage.setImage(i);
        buttonImage.relocate(420, 350);
        buttonImage.setFitWidth(154);
        buttonImage.setFitHeight(52);

        Image b = new Image("File:photos/blueButton.png");
        ImageView back = new ImageView();
        back.setImage(b);
        back.relocate(860, 550);
        back.setFitWidth(130);
        back.setFitHeight(50);

        Label text = new Label("Login");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        text.setTextFill(Color.WHITESMOKE);
        text.relocate(476, 367);

        Label txt = new Label("   Menu");
        txt.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        txt.setTextFill(Color.WHITESMOKE);
        txt.relocate(890, 567);

        Label command = new Label();
        command.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        command.setTextFill(Color.WHITESMOKE);
        command.relocate(377, 240);

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(imageView, userTextField, passwordField, back, txt, buttonImage, text, command);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                try {
                                    if (x > 438 && x < 560) {
                                        if (y > 356 && y < 397) {
                                            String cm = Account.checking(userTextField.getText(), passwordField.getText());
                                            if (cm.contains("welcome")) {
                                                root.getChildren().clear();
                                                showMainMenuOfAccount(scanner, Account.getAccountActivated(), root);
                                                return;
                                            }
                                        }
                                        if (y > 450 && y < 489) {
                                            root.getChildren().clear();
                                            signUpPage(root, scanner);
                                            return;
                                        }
                                    }
                                    if (x > 870 && x < 980 && y > 555 && y < 596) {
                                        root.getChildren().clear();
                                        showMainMenu(scanner, root);
                                        return;
                                    }
                                } catch (Exception name) {
                                }
                            }
                        }
                );
            }
        });
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
