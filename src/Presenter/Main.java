package Presenter;

import View.Show;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    Group root = new Group();
    Scene scene = new Scene(root, 1000,600, Color.rgb(175,166,143));
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread thread = new Thread(new Runnable(){
            public void run(){
//                Image image = new Image("File:menu.jpg");
//                ImageView menu = new ImageView();
//                menu.setImage(image);
//                menu.setFitHeight(600);
//                menu.setFitWidth(1000);
//                Platform.runLater(
//                        new Runnable(){
//                            public void run(){
//                                root.getChildren().addAll(menu);
//
//
//                            }
//                        }
//                );
                Show.showMainMenu(scanner,root);
            }
        });
        thread.start();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Duelyst Game");
        primaryStage.show();
    }
}
