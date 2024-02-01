package com.example.projet_atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloLogin {

    @FXML
    private Button BtnAnnulerAuthent;

    @FXML
    private Button BtnAuthentify;
    @FXML
    private Label LabPassWordIncorrect;

    @FXML
    private TextField NomLogin;
    @FXML
    private PasswordField MotsPassLogin;

    @FXML
    void BtnAnnulerAuthent_click(ActionEvent event) throws IOException{
        Stage stage = (Stage) NomLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Administrateur");
        stage.setScene(new Scene(root));
    }

    @FXML
    void BtnAuthentify_click(ActionEvent event) throws IOException {
        if(NomLogin.getText().equals("Brunel") && MotsPassLogin.getText().equals("Razma30172"))
        {
            Stage stage = (Stage) NomLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("View_admin.fxml"));
            stage.setTitle("Administrateur");
            stage.setScene(new Scene(root));
        }
        else
        {
            LabPassWordIncorrect.setText("Le nom ou Mots de passe est incorrecte");
            NomLogin.setText("");
            MotsPassLogin.setText("");
        }

    }

    @FXML
    void MotsPassLogin_click(ActionEvent event) {

    }

}
