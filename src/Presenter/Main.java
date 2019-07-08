package Presenter;

import Model.*;
import View.Show;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public static Group root = new Group();
    public static Scene scene = new Scene(root, 1000, 600, Color.rgb(175, 166, 143));
    public static Scanner scanner = new Scanner(System.in);
    public static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                SaveAccounts.read();

                Account a = new Account("a", "a");
                Account b = new Account("b", "b");
                Account.addNewAccount(a);
                Account.addNewAccount(b);
                Account.setAccountActivated(a);
                Show.showMainMenuOfAccount(Account.getAccountActivated(),root);

//                Show.showMainMenu( root);
            }
        });
        thread.start();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Duelyst Game");
        primaryStage.show();
    }
}
