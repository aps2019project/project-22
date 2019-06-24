package Presenter;

import View.Show;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public static Group root = new Group();
    public static Scene scene = new Scene(root, 1000,600, Color.rgb(175,166,143));
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread thread = new Thread(new Runnable(){
            public void run(){
                Show.showMainMenu(scanner,root);
            }
        });
        thread.start();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Duelyst Game");
        primaryStage.show();
    }
}
