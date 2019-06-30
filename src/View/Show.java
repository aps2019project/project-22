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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Show {

    private static void showIcons(Group root, int x, int y) {
        Circle[] circles = new Circle[3];
        Line[] lines = new Line[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            circles[i] = new Circle();
            lines[i] = new Line();
            lines[i].setFill(Color.WHITESMOKE);
            circles[i].setFill(Color.WHITE);

            circles[i].setRadius(3);

            circles[i].relocate(x + random.nextInt(10) * (random.nextInt() % 2 == 0 ? 1 : -1),
                    y + random.nextInt(10) * (random.nextInt() % 2 == 0 ? 1 : -1));

            lines[i].setStartX(circles[i].getCenterX());
            lines[i].setStartY(circles[i].getCenterY());

            root.getChildren().addAll(circles[i], lines[i]);
        }
        lines[0].setEndX(circles[1].getCenterX());
        lines[0].setEndY(circles[1].getCenterY());

        lines[1].setEndX(circles[2].getCenterX());
        lines[1].setEndY(circles[2].getCenterY());

        lines[2].setEndX(circles[0].getCenterX());
        lines[2].setEndY(circles[0].getCenterY());

    }

    public static void showMainMenuOfAccount(Account account, Group root) {

        Image image = new Image("File:photos/menuOfAccount.jpg");
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
        label1.relocate(193, 175);
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

        String uriString = new File("musics/menuOfAccountSong.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                                        mediaPlayer.stop();
                                        showCollectionMenu(root, account);
                                        return;
                                    }
                                    if (x < 300 && y > 214 && y < 256) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        shopMenu(account, root);////////////
                                        return;
                                    }
                                    if (x < 300 && y > 262 && y < 294) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        Battle battle = new Battle();
                                        showBattleMenu(account, battle, root, "Choose Opponent");
                                        return;
                                    }
                                    if (x < 300 && y > 298 && y < 330) {
                                        SaveAccounts.save();
                                        popUpWindow("SAVED", 280, 120);
                                        showMainMenuOfAccount(account, root);
                                        return;
                                    }
                                    if (x > 169 && x < 289 && y >= 350 && y < 382) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        showCreateCustomCard(root);
                                        return;
                                    }
                                    if (x > 169 && x < 284 && y > 390 && y < 424) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        showMainMenu(root);
                                        return;
                                    }
                                } else if (x > 26 && x < 108 && y > 507 && y < 589) {
                                    root.getChildren().clear();
                                    mediaPlayer.stop();
                                    showExitPage(root);
                                    return;
                                }
                            }
                        });
            }
        });
    }

    private static void showCollectionMenu(Group root, Account account) {

        String uriString = new File("musics/board.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

        Image image = new Image("File:photos/bg4.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);
        root.getChildren().add(imageView);

        Image b = new Image("File:photos/closeButton.png");
        ImageView back = new ImageView();
        back.setImage(b);
        back.relocate(0, 530);
        back.setFitWidth(70);
        back.setFitHeight(70);

        Label[] labels = new Label[11];
        ImageView[] options = new ImageView[11];
        for (int i = 0; i < 11; i++) {
            options[i] = new ImageView();
            labels[i] = new Label();
            labels[i].relocate(780, 49 + i * 40);
            labels[i].setFont(Font.font("Verdana", FontWeight.BOLD, 15));
            labels[i].setTextFill(Color.DARKBLUE);
            labels[i].setPrefHeight(60);
            options[i].relocate(900, 50 + i * 40);
            options[i].setFitWidth(60);
            options[i].setFitHeight(60);
            root.getChildren().addAll(options[i], labels[i]);
        }

        options[3].setFitWidth(68);
        options[3].setFitHeight(68);
        options[3].setTranslateY(options[3].getY() - 4);
        options[7].setTranslateY(options[7].getY() - 4);
        options[3].setTranslateX(options[3].getX() - 4);
        options[7].setTranslateX(options[7].getX() - 4);
        options[7].setFitWidth(68);
        options[7].setFitHeight(68);

        Image blue = new Image("File:photos/blueOC.png");
        Image gray = new Image("File:photos/grayOC.png");
        Image green = new Image("File:photos/greenOC.png");
        Image purple = new Image("File:photos/purpleOC.png");

        options[0].setImage(blue);
        options[1].setImage(gray);
        options[2].setImage(purple);
        options[3].setImage(green);
        options[4].setImage(blue);
        options[5].setImage(gray);
        options[6].setImage(purple);
        options[7].setImage(green);
        options[8].setImage(blue);
        options[9].setImage(purple);
        options[10].setImage(gray);

        labels[0].setText("Show");
        labels[1].setText("Search");
        labels[2].setText("Save");
        labels[3].setText("Create Deck");
        labels[4].setText("Delete Deck");
        labels[5].setText("Add Card");
        labels[6].setText("Remove Card");
        labels[7].setText("Validate Deck");
        labels[8].setText("Select Deck");
        labels[9].setText("Show All Decks");
        labels[10].setText("Show Deck");


        back.setImage(b);

        root.getChildren().addAll(back);

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                if (x < 940 && x > 919 && y < 500 && y > 66) {

                    root.getChildren().clear();
                    root.getChildren().addAll(imageView, back);
                    for (int i = 0; i < 11; i++)
                        root.getChildren().addAll(options[i], labels[i]);

                    if (y > 67 && y < 90) { // show collection
                        Label label = new Label();
                        label.relocate(50, 100);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        System.out.println(showCollection(account));
                        label.setText(showCollection(account));
                        root.getChildren().addAll(label);
                        return;
                    }
                    if (y > 106 && y < 135) { //search

                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(119, 196);

                        Label label = new Label();
                        label.relocate(119, 150);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Card Name");

                        Button button = new Button();
                        button.setText("Search");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(138, 240);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                int num = account.getCollection().search(input.getText());
                                if (num != -1)
                                    popUpWindow("number = " + num, 280, 120);
                                else
                                    popUpWindow("Not Found. :(", 280, 120);
                            }
                        });

                        root.getChildren().addAll(input, label, button);
                        return;
                    }
                    if (y > 147 && y < 177) { // save
                        account.getCollection().save();
                        popUpWindow("SAVED", 280, 120);
                        return;
                    }
                    if (y > 185 && y < 215) {//create deck
                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(119, 196);

                        Label label = new Label();
                        label.relocate(119, 150);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Deck Name");

                        Button button = new Button();
                        button.setText("Create!");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(138, 240);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                popUpWindow(Deck.createDeck(input.getText(), account), 280, 120);
                            }
                        });

                        root.getChildren().addAll(input, label, button);
                        return;
                    }
                    if (y > 226 && y < 254) { //delete deck
                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(119, 196);

                        Label label = new Label();
                        label.relocate(119, 150);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Deck Name");

                        Button button = new Button();
                        button.setText("Delete!");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(138, 240);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                popUpWindow(Deck.deleteDeck(input.getText(), account), 280, 120);
                            }
                        });

                        root.getChildren().addAll(input, label, button);
                        return;
                    }
                    if (y > 266 && y < 295) { // add

                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(50, 120);

                        Label label = new Label();
                        label.relocate(50, 80);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Deck Name");

                        TextField input2 = new TextField();
                        input2.setPrefWidth(120);
                        input2.setMaxHeight(40);
                        input2.relocate(50, 196);

                        Label label2 = new Label();
                        label2.relocate(50, 156);
                        label2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label2.setTextFill(Color.LIGHTPINK);
                        label2.setPrefHeight(60);
                        label2.setText("ID");

                        Button button = new Button();
                        button.setText("Add");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(138, 240);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try {
                                    popUpWindow(Deck.searchDeckByName(input.getText()).addCard
                                            (Integer.parseInt(input2.getText()), account), 280, 120);
                                } catch (Exception name) {
                                    popUpWindow("DeckName Is Invalid", 280, 120);
                                }
                            }
                        });

                        root.getChildren().addAll(input, label, input2, label2, button);
                        return;
                    }
                    if (y > 306 && y < 336) { //remove

                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(50, 120);

                        Label label = new Label();
                        label.relocate(50, 80);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Deck Name");

                        TextField input2 = new TextField();
                        input2.setPrefWidth(120);
                        input2.setMaxHeight(40);
                        input2.relocate(50, 196);

                        Label label2 = new Label();
                        label2.relocate(50, 156);
                        label2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label2.setTextFill(Color.LIGHTPINK);
                        label2.setPrefHeight(60);
                        label2.setText("ID");

                        Button button = new Button();
                        button.setText("Remove");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(138, 240);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                popUpWindow(account.removeCardFromDeckByIdAndName(Integer.parseInt(input2.getText()), input.getText())
                                        , 280, 120);
                            }
                        });

                        root.getChildren().addAll(input, label, input2, label2, button);
                        return;
                    }
                    if (y > 344 && y < 375) { // validate
                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(119, 196);

                        Label label = new Label();
                        label.relocate(119, 150);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Deck Name");

                        Button button = new Button();
                        button.setText("Validate");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(138, 240);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                popUpWindow(account.checkIsValidate(input.getText()), 280, 120);
                            }
                        });

                        root.getChildren().addAll(input, label, button);
                        return;
                    }
                    if (y > 385 && y < 414) { //select
                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(119, 196);

                        Label label = new Label();
                        label.relocate(119, 150);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Deck Name");

                        Button button = new Button();
                        button.setText("Select");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(138, 240);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                popUpWindow(account.setMainDeckByName(input.getText()), 280, 120);
                            }
                        });

                        root.getChildren().addAll(input, label, button);
                        return;
                    }
                    if (y > 427 && y < 454) { //show  all deck
                        Label label = new Label();
                        label.relocate(50, 100);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText(account.showAllDecks());
                        root.getChildren().addAll(label);
                        return;
                    }
                    if (y > 465 && y < 494) { // show deck
                        Label str = new Label();
                        str.relocate(50, 100);
                        str.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        str.setTextFill(Color.LIGHTPINK);
                        str.setPrefHeight(60);

                        TextField input = new TextField();
                        input.setPrefWidth(120);
                        input.setMaxHeight(40);
                        input.relocate(100, 496);

                        Label label = new Label();
                        label.relocate(100, 450);
                        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        label.setTextFill(Color.LIGHTPINK);
                        label.setPrefHeight(60);
                        label.setText("Deck Name");

                        Button button = new Button();
                        button.setText("Show");
                        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                        button.relocate(130, 530);

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                str.setText(account.showDeckByName(input.getText()));
                            }
                        });

                        root.getChildren().addAll(input, label, button, str);
                        return;
                    }
                }
                if (x < 65 && x > 10 && y < 590 && y > 537) {
                    root.getChildren().clear();
                    mediaPlayer.stop();
                    showMainMenuOfAccount(account, root);
                    return;
                }
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

        Image b = new Image("File:photos/pinkButton.png");
        ImageView back = new ImageView();
        back.setImage(b);
        back.relocate(880, 495);
        back.setFitWidth(120);
        back.setFitHeight(120);

        root.getChildren().addAll(button, label, back);

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                if (x > 918 && x < 968 && y > 530 && y < 580) {
                    showMainMenuOfAccount(Account.getAccountActivated(), root);
                    return;
                }

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
    }

    public static String showCollection(Account account) {
        Collection collection = account.getCollection();
        String string = "Heroes :\n";
        int number = 1;
        for (int i = 0; i < collection.getHeroes().size(); i++) {
            string += "\t" + number + " : Name : " + collection.getHeroes().get(i).getName() + " - AP : " +
                    collection.getHeroes().get(i).getAttackPower() + " - HP : " + collection.getHeroes().get(i).
                    getHealthPoint() + " - Class : " + collection.getHeroes().get(i).getTypeOfAttack() +
                    " - Special power: " + "attack" + " - price: " + collection.getHeroes().get(i).getPrice() + " Id= " +
                    collection.getHeroes().get(i).getId() + "\n";
            number++;
        }
        number = 1;
        string += "Items :\n";
        for (int i = 0; i < collection.getItems().size(); i++) {
            string += ("\t" + number + " : Name : " + collection.getItems().get(i).getName() + " Desc: " +
                    collection.getItems().get(i).getDescription() + " - price: " + collection.getItems().get(i).getPrice()
                    + " ID=" + collection.getItems().get(i).getId() + "\n");
            number++;
        }
        number = 1;
        string += ("Cards :\n");
        for (int i = 0; i < collection.getSpells().size(); i++) {
            string += ("\t" + number + " : Type : Spell - Name : " + collection.getSpells().get(i).getName() +
                    " - MP : " + collection.getSpells().get(i).getManaPoint() + " - " +
                    collection.getSpells().get(i).getDescription() + " - price: " + collection.getSpells().get(i).getPrice()
                    + " ID= " + collection.getSpells().get(i).getId() + "\n");
            number++;
        }
        for (int i = 0; i < collection.getMinions().size(); i++) {
            string += ("\t" + number + " : Type : Minion - Name : " + collection.getMinions().get(i).getName()
                    + " - Class: " + collection.getMinions().get(i).getTypeOfAttack() + " - AP : " + collection.
                    getMinions().get(i).getAttackPower() + " - HP : " + collection.getMinions().get(i).getHealthPoint()
                    + " - MP : " + collection.getMinions().get(i).getManaPoint() + " - Special power : " +
                    collection.getMinions().get(i).getSpecialPower() + " - price: " + collection.getMinions().get(i).getPrice()
                    + " ID= " + collection.getMinions().get(i).getId() + "\n");
            number++;
        }
        return string;
    }

    public static void showBattleMenu(Account account, Battle battle, Group root, String command) {

        Image image = new Image("File:photos/opponents.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);
        root.getChildren().add(imageView);

        String uriString = new File("musics/chooseOpponent.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                    mediaPlayer.stop();
                    showBattleMenu(account, battle, root, "Please Enter A Number.");
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
                mediaPlayer.stop();
                selectGamePage(root, account, battle, player1, player2);
            }
        });
    }

    private static void playGame(int storyCustom, int singleMulti, Account account, Battle battle
            , Group root, Player player1, Player player2,
                                 int levelOfGame) //akharesh ?!
    {

        String uriString = new File("musics/battle.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                player1.addCardsInTheFile(Card.searchCardByID(68));
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
            getInputs(root, battle);
            battle.fight(account, root);
        }
    }

    private static void getInputs(Group root, Battle battle) {
        TextField input = new TextField();
        input.setPrefWidth(120);
        input.setMaxHeight(40);
        input.relocate(5, 410);

        Label label = new Label();
        label.relocate(5, 374);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        label.setTextFill(Color.LIGHTPINK);
        label.setPrefHeight(60);
        label.setText("Enter Deck Name | mode | number Of Flags");

        Button button = new Button();
        button.setText("Start Game");
        button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        button.relocate(15, 484);

        root.getChildren().addAll(input, label, button);


        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                popUpWindow(((CustomGame) battle).setCoustomGame(input.getText()), 280, 120);
                if (!((CustomGame) battle).setCoustomGame(input.getText()).equals("Successful."))
                    getInputs(root, battle);
                else
                    root.getChildren().removeAll(input, label, button);
            }
        });
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
        text1.relocate(258, 410);

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

        String uriString = new File("musics/chooseOpponent.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                                    mediaPlayer.stop();
                                    selectMode(root, account, battle, player1, player2, 1);
                                }
                                if (x > 645 && x < 766 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    mediaPlayer.stop();
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

        String uriString = new File("musics/chooseOpponent.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                                    mediaPlayer.stop();
                                    selectLevel(root, account, battle, player1, player2, singleMulti, 1);
                                }
                                if (x > 645 && x < 766 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    mediaPlayer.stop();
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

        String uriString = new File("musics/graveyard.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                Platform.runLater(
                        new Runnable() {
                            public void run() {
                                if (x > 256 && x < 374 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    mediaPlayer.stop();
                                    playGame(storyCustom, singleMulti, account, battle, root, player1, player2, 1);
                                }
                                if (x > 440 && x < 560 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    mediaPlayer.stop();
                                    playGame(storyCustom, singleMulti, account, battle, root, player1, player2, 2);
                                }
                                if (x > 645 && x < 766 && y > 403 && y < 439) {
                                    root.getChildren().clear();
                                    mediaPlayer.stop();
                                    playGame(storyCustom, singleMulti, account, battle, root, player1, player2, 3);
                                }
                            }
                        }
                );
            }
        });
    }

    public static void showMainMenu(Group root) {

        Image image = new Image("File:photos/menu.jpg");
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
        label4.relocate(198, 312);
        label4.setTextFill(Color.WHITESMOKE);

        Image i5 = new Image("file:photos/grayButton.png");
        ImageView buttonImage5 = new ImageView();
        buttonImage5.setImage(i5);
        buttonImage5.relocate(154, 340);
        buttonImage5.setFitWidth(146);
        buttonImage5.setFitHeight(45);

        Label label5 = new Label("Grave Yard");
        label5.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        label5.relocate(187, 352);
        label5.setTextFill(Color.WHITESMOKE);

        ImageView icon = new ImageView();
        icon.setImage(new Image("file:photos/graveIcon.png"));
        icon.relocate(113, 340);
        icon.setFitWidth(55);
        icon.setFitHeight(55);

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

        String uriString = new File("musics/mainMenuSong.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(menu, buttonImage, buttonImage1, label1, buttonImage2, label2,
                                buttonImage3, label3, buttonImage4, label4, buttonImage5, label5, icon, exitButton);
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
                                        mediaPlayer.stop();
                                        signUpPage(root);
                                        return;
                                    }
                                    if (x < 300 && y > 214 && y < 256) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        loginPage(root);
                                        return;
                                    }
                                    if (x < 300 && y > 262 && y < 294) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        boardPage(root);
                                        return;
                                    }
                                    if (x > 174 && x < 285 && y < 333 && y > 308) {
                                        SaveAccounts.save();
                                        popUpWindow("Saved ;)", 280, 120);
                                    }
                                    if (x > 173 && x < 281 && y < 379 && y > 348) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        graveyardPage(root);
                                        return;
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

    private static void graveyardPage(Group root) {
        Image image = new Image("File:photos/bg5.jpg");
        ImageView board = new ImageView();
        board.setImage(image);
        board.setFitHeight(600);
        board.setFitWidth(1000);

        Text sceneTitle = new Text("GRAVEYARD");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        sceneTitle.setFill(Color.MEDIUMSLATEBLUE);
        sceneTitle.relocate(8, 10);

//        GraveYard.addSpell(new Spell(54, "test", 90, 78, "f", "p"));

        Line underline = new Line(5, 38, 150, 38);
        underline.setFill(Color.BLACK);

        Image b = new Image("File:photos/black0.png");
        ImageView back = new ImageView();
        back.setImage(b);
        back.relocate(920, 515);
        back.setFitWidth(70);
        back.setFitHeight(70);

        String uriString = new File("musics/graveyard.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(board, sceneTitle, back, underline);
                        double y = 150;
                        y = printSpells(y, root);
                        y = printHeroes(y, root);
                        printMinions(y, root);
                    }
                }
        );

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();
                if (x > 931 && x < 985 && y > 524 && y < 577) {
                    root.getChildren().clear();
                    mediaPlayer.stop();
                    showMainMenu(root);
                }
            }
        });
    }

    private static void printMinions(double y, Group root) {
        for (int i = 0; i < GraveYard.getMinions().size(); i++) {
            Label username = new Label();
            username.setText("Minion Name: " + GraveYard.getMinions().get(i).getName() +
                    "\tID: " + GraveYard.getMinions().get(i).getId() + "\tPrice: " + GraveYard.getMinions().get(i).getPrice());
            username.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            username.setTextFill(Color.BLACK);
            username.relocate(250, y + 30 * i);
            y = username.getTranslateY();

            root.getChildren().addAll(username);
        }
    }

    private static double printSpells(double y, Group root) {
        for (int i = 0; i < GraveYard.getSpells().size(); i++) {
            Label username = new Label();
            username.setText("Spell Name: " + GraveYard.getSpells().get(i).getName() +
                    "\tID: " + GraveYard.getSpells().get(i).getId() + "\tPrice: " + GraveYard.getSpells().get(i).getPrice());
            username.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            username.setTextFill(Color.BLACK);
            username.relocate(250, y + 30 * i);
            y = username.getTranslateY();

            root.getChildren().addAll(username);
        }
        return y;
    }

    private static double printHeroes(double y, Group root) {
        for (int i = 0; i < GraveYard.getHeroes().size(); i++) {
            Label username = new Label();
            username.setText("Hero Name: " + GraveYard.getHeroes().get(i).getName() +
                    "\tID: " + GraveYard.getHeroes().get(i).getId() + "\tPrice: " + GraveYard.getHeroes().get(i).getPrice());
            username.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            username.setTextFill(Color.BLACK);
            username.relocate(250, 150 + 30 * i);
            y = username.getTranslateY();

            root.getChildren().addAll(username);
        }
        return y;
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

    private static void boardPage(Group root) {
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

        String uriString = new File("musics/board.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

        Platform.runLater(
                new Runnable() {
                    public void run() {
                        root.getChildren().addAll(board, sceneTitle, back, underline);
                    }
                }
        );

        Account.sortAll();

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX(), y = event.getY();

                for (int i = 0; i < Account.getAccounts().size(); i++) {
                    Label username = new Label();
                    username.setText(i + 1 + ".\tUsername: " + Account.getAccounts().get(i).getUserName());
                    username.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
                    username.setTextFill(Color.DEEPPINK);
                    username.relocate(250, 150 + 36 * i);

                    Label wins = new Label();
                    wins.setText("Wins: " + Account.getAccounts().get(i).getWins());
                    wins.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
                    wins.setTextFill(Color.DEEPPINK);
                    wins.relocate(575, 150 + 36 * i);

                    root.getChildren().addAll(username, wins);
                }

                if (x > 931 && x < 985 && y > 524 && y < 577) {
                    root.getChildren().clear();
                    mediaPlayer.stop();
                    showMainMenu(root);
                    return;
                }
            }
        });
    }

    private static void signUpPage(Group root) {
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

        String uriString = new File("musics/signUp.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                                        mediaPlayer.stop();
                                        showMainMenu(root);
                                    }
                                }
                                if (x > 918 && x < 968 && y > 530 && y < 580) {
                                    root.getChildren().clear();
                                    mediaPlayer.stop();
                                    showMainMenu(root);
                                }
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

    public static void loginPage(Group root) {

        Image image = new Image("File:photos/loginpage.jpg");
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
        command.setTextFill(Color.rgb(200, 255, 255));
        command.relocate(377, 240);

        String uriString = new File("musics/login.mp3").toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();

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
                                            command.setText(cm);
                                            if (cm.contains("welcome")) {
                                                root.getChildren().clear();
                                                mediaPlayer.stop();
                                                showMainMenuOfAccount(Account.getAccountActivated(), root);
                                                return;
                                            }
                                        }
                                        if (y > 450 && y < 489) {
                                            root.getChildren().clear();
                                            mediaPlayer.stop();
                                            signUpPage(root);
                                            return;
                                        }
                                    }
                                    if (x > 870 && x < 980 && y > 555 && y < 596) {
                                        root.getChildren().clear();
                                        mediaPlayer.stop();
                                        showMainMenu(root);
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

    private static void shopMenu(Account account, Group root) {

        Image shop = new Image("file:shop.jpg");
        ImageView background = new ImageView();
        background.setFitWidth(1000);
        background.setFitHeight(600);
        background.setImage(shop);

        Image button = new Image("File:button.png");
        Label labelSearch = new Label("search");
        labelSearch.setFont(Font.font(20));
        labelSearch.setTextFill(Color.WHITE);
        labelSearch.relocate(305, 170);

        ImageView search = new ImageView();
        search.setImage(button);
        search.relocate(250, 160);

        Label sellLabel = new Label("sell");
        sellLabel.relocate(620, 170);
        sellLabel.setFont(Font.font(20));
        sellLabel.setTextFill(Color.WHITE);

        ImageView sell = new ImageView();
        sell.setImage(button);
        sell.relocate(550, 160);

        ImageView buy = new ImageView();
        Label buyLabel = new Label("buy");
        buyLabel.relocate(320, 370);
        buyLabel.setTextFill(Color.WHITE);
        buyLabel.setFont(Font.font(20));
        buy.setImage(button);
        buy.relocate(250, 360);

        Label showLabel = new Label("show collection");
        showLabel.relocate(565, 370);
        showLabel.setFont(Font.font(20));
        showLabel.setTextFill(Color.WHITE);

        ImageView show = new ImageView();
        show.setImage(button);
        show.relocate(550, 360);

        Image b = new Image("File:photos/pinkButton.png");
        ImageView back = new ImageView();
        back.setImage(b);
        back.relocate(880, 495);
        back.setFitWidth(120);
        back.setFitHeight(120);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                root.getChildren().addAll(background, search, show, sell, buy, buyLabel, showLabel, sellLabel, labelSearch, back);
            }
        });

        Image inside = new Image("file:inside.jpg");
        ImageView insideShop = new ImageView();
        insideShop.setFitHeight(600);
        insideShop.setFitWidth(1000);
        insideShop.setImage(inside);

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                double mainX = event.getSceneX();
                double mainY = event.getSceneY();

                if (mainX > 918 && mainX < 968 && mainY > 530 && mainY < 580) { //back
                    root.getChildren().clear();
                    showMainMenuOfAccount(account, root);
                    return;
                }
                if (mainX >= 269 && mainX <= 405 && mainY >= 166 && mainY <= 210) {  //search

                    TextField input = new TextField();
                    input.setPrefWidth(120);
                    input.setMaxHeight(40);
                    input.relocate(119, 196);

                    Label label = new Label();
                    label.relocate(119, 150);
                    label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                    label.setTextFill(Color.LIGHTPINK);
                    label.setPrefHeight(60);
                    label.setText("Search Collection");

                    Button button = new Button();
                    button.setText("Search");
                    button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                    button.relocate(138, 240);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            root.getChildren().clear();
                            root.getChildren().addAll(button, label, input, insideShop, back);
                        }
                    });
                    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (account.getCollection().search(input.getText()) != -1) {
                                Label answer = new Label("card exist in collection");
                                answer.setFont(Font.font(25));
                                answer.relocate(600, 196);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().addAll(answer);
                                    }
                                });
                            } else {
                                Label answer = new Label("Not Found!");
                                answer.setFont(Font.font(25));
                                answer.relocate(600, 196);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().addAll(answer);
                                    }
                                });
                            }

                        }
                    });

                    TextField input2 = new TextField();
                    input2.setPrefWidth(120);
                    input2.setMaxHeight(40);
                    input2.relocate(119, 396);

                    Label label2 = new Label();
                    label2.relocate(119, 350);
                    label2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                    label2.setTextFill(Color.LIGHTPINK);
                    label2.setPrefHeight(60);
                    label2.setText("Search Shop");

                    Button button2 = new Button();
                    button2.setText("Search");
                    button2.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                    button2.relocate(138, 440);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            root.getChildren().addAll(button2, label2, input2);
                        }
                    });
                    button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (Shop.searchByName(input2.getText()) != -1) {
                                Label answer = new Label("card exist in collection");
                                answer.setFont(Font.font(25));
                                answer.setTextFill(Color.WHITE);
                                answer.relocate(600, 396);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().addAll(answer);
                                    }
                                });
                            } else {
                                Label answer = new Label("Not Found!");
                                answer.setFont(Font.font(25));
                                answer.relocate(600, 396);
                                answer.setTextFill(Color.WHITE);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().addAll(answer);
                                    }
                                });
                            }
                        }
                    });
                    root.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            double x = event.getX(), y = event.getY();
                            if (x > 918 && x < 968 && y > 530 && y < 580) { //back
                                root.getChildren().clear();
                                shopMenu(account, root);
                                return;
                            }
                        }
                    });
                }
                else if (mainX >= 570 && mainX <= 704 && mainY >= 168 && mainY <= 207) { // sell
                    root.getChildren().clear();
                    root.getChildren().addAll(insideShop, back);

                    TextField input = new TextField();
                    input.setPrefWidth(120);
                    input.setMaxHeight(40);
                    input.relocate(119, 196);

                    Label label = new Label();
                    label.relocate(119, 150);
                    label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                    label.setTextFill(Color.LIGHTPINK);
                    label.setPrefHeight(60);
                    label.setText("give id to sell card");

                    Button button = new Button();
                    button.setText("sell");
                    button.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                    button.relocate(138, 240);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            root.getChildren().clear();
                            root.getChildren().addAll(insideShop,button, label, input, back);
                        }
                    });

                    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Shop.sell(input.getText(), account, root);
                        }
                    });
                    root.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            double x = event.getX(), y = event.getY();
                            if (x > 918 && x < 968 && y > 530 && y < 580) { //back
                                root.getChildren().clear();
                                Show.shopMenu(account, root);
                                return;
                            }
                            if (x > 918 && x < 968 && y > 530 && y < 580) { //back
                                root.getChildren().clear();
                                shopMenu(account, root);
                                return;
                            }
                        }
                    });
                }
                else if (mainX >= 270 && mainX <= 403 && mainY >= 365 && mainY <= 409) { //buy

                    root.getChildren().clear();
                    root.getChildren().addAll(insideShop, back);

                    Image hero = new Image("file:heroCard.PNG");
                    Image minion = new Image("file:minionCard.PNG");
                    Image item = new Image("file:itemCard.PNG");
                    Image spell = new Image("file:spellCard.PNG");
                    Label heroLabel = new Label("Hero");
                    Label itemLabel = new Label("Item");
                    Label spellLabel = new Label("Spell");
                    Label minionLabel = new Label("Minion");

                    ImageView im1 = new ImageView();
                    im1.setImage(item);
                    im1.relocate(125, 200);
                    im1.setFitWidth(150);
                    im1.setFitHeight(200);

                    itemLabel.relocate(170, 450);
                    itemLabel.setTextFill(Color.YELLOW);
                    itemLabel.setFont(Font.font(25));

                    ImageView im2 = new ImageView();
                    im2.setFitHeight(200);
                    im2.setFitWidth(150);
                    im2.relocate(325, 200);
                    im2.setImage(spell);

                    spellLabel.relocate(370, 450);
                    spellLabel.setFont(Font.font(25));
                    spellLabel.setTextFill(Color.YELLOW);

                    ImageView im3 = new ImageView();
                    im3.setFitWidth(150);
                    im3.setFitHeight(200);
                    im3.setImage(hero);
                    im3.relocate(525, 200);

                    heroLabel.setFont(Font.font(25));
                    heroLabel.relocate(570, 450);
                    heroLabel.setTextFill(Color.YELLOW);

                    ImageView im4 = new ImageView();
                    im4.setImage(minion);
                    im4.relocate(725, 200);
                    im4.setFitHeight(200);
                    im4.setFitWidth(150);

                    minionLabel.relocate(763, 450);
                    minionLabel.setTextFill(Color.YELLOW);
                    minionLabel.setFont(Font.font(25));

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            root.getChildren().addAll(im1, im2, im3, im4, spellLabel, minionLabel, heroLabel, itemLabel);
                        }
                    });

                    root.setOnMouseClicked(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {
                            double x = event.getSceneX();
                            double y = event.getSceneY();

                            if (x > 918 && x < 968 && y > 530 && y < 580) { //back
                                root.getChildren().clear();
                                shopMenu(account, root);
                                return;
                            }
                            if (x >= 125 && x <= 275 && y >= 200 && y <= 400) {

                                MakeItems.make();
                                ImageView items[] = new ImageView[20];
                                Label itemLabels[] = new Label[20];

                                int X = 50, Y = 100, num = 0;
                                for (int j = 0; j < 4; j++) {
                                    for (int i = 0; i < 5; i++) {
                                        num = ((j * 5) + i);
                                        items[num] = new ImageView();
                                        itemLabels[num] = new Label(Item.getItems().get(num).getName());
                                        items[num].setImage(button);
                                        itemLabels[num].setFont(Font.font(20));
                                        itemLabels[num].setTextFill(Color.WHITE);
                                        itemLabels[num].relocate(X + 20, Y + 10);
                                        items[num].relocate(X, Y);
                                        X += 175;
                                    }
                                    X = 50;
                                    Y += 100;
                                }

                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().clear();
                                        root.getChildren().addAll(insideShop, back);
                                        root.getChildren().addAll(items);
                                        root.getChildren().addAll(itemLabels);
                                    }
                                });

                                root.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent event) {
                                        double xminion = event.getSceneX();
                                        double yminion = event.getSceneY();
                                        if (xminion > 918 && xminion < 968 && yminion > 530 && yminion < 580) { //back
                                            root.getChildren().clear();
                                            Show.shopMenu(account, root);
                                            return;
                                        }
                                        int xx = ((int) xminion - 50) / 175;
                                        int yy = ((int) yminion - 100) / 100;
                                        int num = (yy * 5) + xx;
                                        popUpWindow(Shop.buy(itemLabels[num].getText(), account, items, itemLabels, num, root),280,120);
                                    }
                                });
                            } else if (x >= 325 && x <= 475 && y >= 200 && y <= 400) {
                                MakeSpell.make();
                                ImageView spells[] = new ImageView[20];
                                Label spellLabels[] = new Label[20];
                                int X = 50, Y = 80, num = 0;
                                for (int j = 0; j < 4; j++) {
                                    for (int i = 0; i < 5; i++) {
                                        num = ((j * 5) + i);
                                        spells[num] = new ImageView();
                                        spellLabels[num] = new Label(Spell.getSpells().get(num).getName());
                                        spells[num].setImage(button);
                                        spellLabels[num].setFont(Font.font(20));
                                        spellLabels[num].setTextFill(Color.WHITE);
                                        spellLabels[num].relocate(X + 20, Y + 10);
                                        spells[num].relocate(X, Y);
                                        X += 175;
                                    }
                                    X = 50;
                                    Y += 100;
                                }
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().clear();
                                        root.getChildren().addAll(insideShop,back);
                                        root.getChildren().addAll(spells);
                                        root.getChildren().addAll(spellLabels);
                                    }
                                });

                                root.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent event) {
                                        double xminion = event.getSceneX();
                                        double yminion = event.getSceneY();
                                        if (xminion > 918 && xminion < 968 && yminion > 530 && yminion < 580) { //back
                                            root.getChildren().clear();
                                            Show.shopMenu(account, root);
                                            return;
                                        }
                                        int xx = ((int) xminion - 50) / 175;
                                        int yy = ((int) yminion - 80) / 100;
                                        int num = (yy * 5) + xx;
                                       popUpWindow( Shop.buy(spellLabels[num].getText(), account, spells,
                                                spellLabels, num, root),280,120);
                                    }
                                });
                            }
                            else if (x >= 525 && x <= 675 && y >= 200 && y <= 400) {
                                MakeHero.make();
                                ImageView hero[] = new ImageView[10];
                                Label heroLabels[] = new Label[10];
                                int X = 50, Y = 200, num = 0;
                                for (int j = 0; j < 2; j++) {
                                    for (int i = 0; i < 5; i++) {
                                        num = ((j * 5) + i);
                                        hero[num] = new ImageView();
                                        heroLabels[num] = new Label(Hero.getHeroes().get(num).getName());
                                        hero[num].setImage(button);
                                        heroLabels[num].setFont(Font.font(20));
                                        heroLabels[num].setTextFill(Color.WHITE);
                                        heroLabels[num].relocate(X + 20, Y + 10);
                                        hero[num].relocate(X, Y);
                                        X += 175;
                                    }
                                    X = 50;
                                    Y += 100;
                                }
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().clear();
                                        root.getChildren().addAll(insideShop,back);
                                        root.getChildren().addAll(hero);
                                        root.getChildren().addAll(heroLabels);
                                    }
                                });

                                root.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent event) {
                                        double xminion = event.getSceneX();
                                        double yminion = event.getSceneY();
                                        if (xminion > 918 && xminion < 968 && yminion > 530 && yminion < 580) { //back
                                            root.getChildren().clear();
                                            Show.shopMenu(account, root);
                                            return;
                                        }
                                        int xx = ((int) xminion - 50) / 175;
                                        int yy = ((int) yminion - 200) / 100;
                                        int num = (yy * 5) + xx;
                                        popUpWindow(Shop.buy(heroLabels[num].getText(), account, hero, heroLabels, num, root),280,120);
                                    }
                                });
                            } else if (x >= 725 && x <= 875 && y >= 200 && y <= 400) {
                                MakeMinions.make();
                                ImageView minions[] = new ImageView[40];
                                Label minionLabels[] = new Label[40];
                                int X = 50, Y = 50, num = 0;
                                for (int j = 0; j < 8; j++) {
                                    for (int i = 0; i < 5; i++) {
                                        num = ((j * 5) + i);
                                        minions[num] = new ImageView();
                                        minionLabels[num] = new Label(Minion.getMinions().get(num).getName());
                                        minions[num].setImage(button);
                                        minionLabels[num].setFont(Font.font(20));
                                        minionLabels[num].setTextFill(Color.WHITE);
                                        minionLabels[num].relocate(X + 20, Y + 10);
                                        minions[num].relocate(X, Y);
                                        X += 175;
                                    }
                                    X = 50;
                                    Y += 60;
                                }
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        root.getChildren().clear();
                                        root.getChildren().addAll(insideShop,back);
                                        root.getChildren().addAll(minions);
                                        root.getChildren().addAll(minionLabels);
                                    }
                                });
                                root.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        double xminion = event.getSceneX();
                                        double yminion = event.getSceneY();
                                        if (xminion > 918 && xminion < 968 && yminion > 530 && yminion < 580) { //back
                                            root.getChildren().clear();
                                            Show.shopMenu(account, root);
                                            return;
                                        }
                                        int xx = ((int) xminion - 50) / 175;
                                        int yy = ((int) yminion - 50) / 60;
                                        int num = (yy * 5) + xx;

                                        popUpWindow(Shop.buy(minionLabels[num].getText(), account, minions, minionLabels,
                                                num, root),280,120);
                                    }
                                });
                            }
                        }
                    });
                }
                else if (mainX >= 573 && mainX <= 701 && mainY >= 369 && mainY <= 406) { // collection menu
                    root.getChildren().clear();
                    showCollectionMenu(root, account);
                    return;
                }
            }
        });
    }

}