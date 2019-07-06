import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {
    Group root = new Group();
    public static void main(String[] args) {
        Thread server = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(8000);
                    while (true) { // 2 points
                        Socket socket = serverSocket.accept();
                        new ServerD(socket).start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        server.start();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root,1000,600);
        primaryStage.setScene(scene);
        primaryStage.show();
        mainMenu();


    }
    public void mainMenu(){

        Image server= new Image("file:ser.JPG");
        ImageView iv = new ImageView(server);
        iv.setFitHeight(600);
        iv.setFitWidth(1000);
        Image button = new Image("file:button.PNG");
        ImageView ivbott1 = new ImageView(button);
        ivbott1.relocate(150,200);
        ImageView ivbott2 = new ImageView(button);
        ivbott2.relocate(150,300);
        Label button1 = new Label("Shop");
        button1.relocate(220,213);
        button1.setTextFill(Color.WHITE);
        button1.setFont(Font.font(20));
        Label button2 = new Label("Clients");
        button2.relocate(210,313);
        button2.setTextFill(Color.WHITE);
        button2.setFont(Font.font(20));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                root.getChildren().clear();
                root.getChildren().addAll(iv,ivbott1,ivbott2,button1,button2);
            }
        });

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                if (x >= 150 && x <= 304 && y >= 200 && y <= 250){
                    shop();
                }else if (x >= 150 && x <= 304 && y >= 300 && y <= 350){

                }
            }
        });


    }
    public void shop(){
        root.getChildren().clear();
        Image insideShop= new Image("file:ser.JPG");
        ImageView iv = new ImageView(insideShop);
        iv.setFitHeight(600);
        iv.setFitWidth(1000);
        Image button = new Image("file:button.PNG");
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
                    mainMenu();
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
                                return;
                            }
                            int xx = ((int) xminion - 50) / 175;
                            int yy = ((int) yminion - 100) / 100;
                            int num = (yy * 5) + xx;
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
                            root.getChildren().addAll(insideShop, back);
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
                            popUpWindow(Shop.buy(spellLabels[num].getText(), account, spells,
                                    spellLabels, num, root), 280, 120);
                        }
                    });
                } else if (x >= 525 && x <= 675 && y >= 200 && y <= 400) {
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
                            root.getChildren().addAll(insideShop, back);
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
                            popUpWindow(Shop.buy(heroLabels[num].getText(), account, hero, heroLabels, num, root), 280, 120);
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
                            root.getChildren().addAll(insideShop, back);
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
                                    num, root), 280, 120);
                        }
                    });
                }
            }
        });
    }
}
