package com.example.projet_atm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 719, 632);
        stage.setTitle("Utilisateur");
        stage.setScene(scene);
        stage.show();
    }
    static List<ClasseurClient> ClientList = new ArrayList<>();

    static ServiceFile<ClasseurClient> ServiceClient=new ServiceFile<>("Client.txt",ClasseurClient.class);
    public static void main(String[] args) {
        ServiceClient.Charger(ClientList);
        launch();
    }
}