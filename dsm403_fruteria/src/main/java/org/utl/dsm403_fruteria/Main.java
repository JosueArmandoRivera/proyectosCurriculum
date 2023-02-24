package org.utl.dsm403_fruteria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.security.Principal;

public class Main extends Application {
    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(this.getClass().getResource("Principal.fxml"));
        Scene scene= new Scene(root, 600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fruteria Don toño");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
