package com.example.projet_atm;

//import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Optional;

import static com.example.projet_atm.HelloApplication.ClientList;
import static com.example.projet_atm.HelloApplication.ServiceClient;

public class HelloAdmin {
    private ClientAdmin ClientAdm;
    @FXML
    private TextField RechercheText;
    @FXML
    private Label NumberLab;
    @FXML
    private ComboBox<String> ComboTypeText;

    @FXML
    private TextField CINText;

    @FXML
    private TextField CodePINText;
    @FXML
    private TextField MoneyInStockText;

    @FXML
    private TextField MoneyStockerText;

    @FXML
    private TextField NomText;

    @FXML
    private TextField PrenomText;
    @FXML
    private Button Editer;

    @FXML
    private Button Enregistre;

    @FXML
    private Button ChercherBtn;
    @FXML
    private TableColumn<ClasseurClient, Integer> CodePINTable;

    @FXML
    private TableColumn<ClasseurClient, String> DateToSaveTable;

    @FXML
    private TableColumn<ClasseurClient, Integer> MoneyInStockTable;

    @FXML
    private TableColumn<ClasseurClient, Integer> MoneyStockerTable;

    @FXML
    private TableColumn<ClasseurClient, String> NomTable;

    @FXML
    private TableColumn<ClasseurClient, String> NumCINTable;

    @FXML
    private TableColumn<ClasseurClient, String> PrenomTable;

    @FXML
    private TableView<ClasseurClient> TableViewAdmin;

    @FXML
    private TableColumn<ClasseurClient, String> TypeCompteTable;

    /*@FXML
    private AutoCompleteTextField<?> recherche;*/

    @FXML
    private Button supprime;
    @FXML
    private ComboBox<String> ComboDisponible;
    @FXML
    public void initialize()
    {
        //CodePINText.setDisable(true);
        MoneyInStockText.setDisable(true);

        NumberLab.setText(Integer.toString(ClientList.size()));

        // Limite le TextField à accepter uniquement des nombres entiers
        CodePINText.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        // Applique une validation personnalisée pour limiter les données à 4 chiffres
        CodePINText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 4) {
                CodePINText.setText(oldValue);
            }
        });

        ComboTypeText.setItems(FXCollections.observableArrayList("Standard", "Premium"));
        ComboDisponible.setItems(FXCollections.observableArrayList("Disponible", "Bloquer"));

        CodePINTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, Integer>("CodePIN"));
        NomTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, String>("Nom"));
        PrenomTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, String>("Prenom"));
        NumCINTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, String>("NumCIN"));
        MoneyInStockTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, Integer>("MoneyInStock"));
        MoneyStockerTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, Integer>("MoneyStocker"));
        TypeCompteTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, String>("TypeCompte"));
        DateToSaveTable.setCellValueFactory(new PropertyValueFactory<ClasseurClient, String>("SavingDate"));
        chargerClientTable();

    }
    private void chargerClientTable(){

        ObservableList<ClasseurClient> list = FXCollections.observableArrayList(ClientList);

        TableViewAdmin.setItems(list);

        TableViewAdmin.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ClasseurClient>() {
            @Override
            public void changed (ObservableValue<? extends ClasseurClient> observableValue, ClasseurClient Clt, ClasseurClient t1){
                CodePINText.setText(Integer.toString(t1.getCodePIN()));
                NomText.setText(t1.getNom());
                PrenomText.setText(t1.getPrenom());
                CINText.setText(t1.getNumCIN());
                MoneyInStockText.setText(Integer.toString(t1.getMoneyInStock()));
                MoneyStockerText.setText(Integer.toString(t1.getMoneyStocker()));
                ComboTypeText.setValue(t1.getTypeCompte());
                ComboDisponible.setValue(t1.getDisponibility());

                URLPhotoText.setText("");
                Image image = new Image(t1.getPhoto());
                PhotoRecent.setImage(image);
                //ComboTypeText.setItems(FXCollections.observableArrayList(t1.getTypeCompte()));
            }
        });
    }

    @FXML
    void CINText_click(ActionEvent event) {

    }

    @FXML
    void CodePINText_click(ActionEvent event) {

    }
    @FXML
    void CodePINText_changed(InputMethodEvent event) {

    }

    @FXML
    void NomText_click(ActionEvent event) {

    }

    public HelloAdmin() {
    }


    @FXML
    private Button importButton;
    @FXML
    private ImageView PhotoRecent;
    @FXML
    private TextField URLPhotoText;
    @FXML
    void ImportButton_click(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner une image");
        // Définissez les filtres de fichier si nécessaire
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(importButton.getScene().getWindow());

        if (selectedFile != null) {
            // Copiez le fichier sélectionné vers un dossier spécifique
            File destinationFolder = new File("C:\\Users\\Brunel\\IdeaProjects\\Projet_ATM\\PhotoRecent");
            try {
                Path destinationPath = destinationFolder.toPath().resolve(selectedFile.getName());
                Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

                // Mettez à jour l'ImageView avec le chemin du fichier importé
                Image importedImage = new Image(((Path) destinationPath).toUri().toString());
                PhotoRecent.setImage(importedImage);
            } catch (IOException e) {
                e.printStackTrace();
                // Gérez les erreurs d'entrée/sortie ici
            }
        }
    }

    private void showInfoMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void ChercherBtn_click(ActionEvent event) {
        String recherche=RechercheText.getText();
        ArrayList<ClasseurClient> founds = new ArrayList<>();
        for(int i=0; i<ClientList.size(); i++)
        {
            ClasseurClient current=ClientList.get(i);
            if (current.getNom().contains(recherche) || current.getPrenom().contains(recherche) || current.getNumCIN().contains(recherche) || current.getTypeCompte().contains(recherche) || current.getSavingDate().contains(recherche)){
                founds.add(current);
            }
           /* if (current.getCodePIN()==Integer.parseInt(recherche) || current.getMoneyInStock()==Integer.parseInt(recherche) || current.getMoneyStocker()==Integer.parseInt(recherche)){
                founds.add(current);
            }*/
        }
        if (founds.size() > 0)
        {
            TableViewAdmin.getItems().setAll(founds);
        }
        else {
            TableViewAdmin.getItems().setAll();
        }

        if(recherche=="")
        {
            ObservableList<ClasseurClient> list = FXCollections.observableArrayList(ClientList);

            TableViewAdmin.setItems(list);
        }
    }
    @FXML
    void Editer_click(ActionEvent event) {
        if (CodePINText.getText().equals(""))
        {
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection est NULL");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionner s'il vous plaît");
            alert.show();
            return;
        }
        int selectedIndex = TableViewAdmin.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ClasseurClient Select= ClientList.get(selectedIndex);
            Select.Photo =("C:\\Users\\Brunel\\IdeaProjects\\Projet_ATM\\PhotoRecent\\"+URLPhotoText.getText());
            Select.CodePIN = Integer.parseInt(CodePINText.getText());
            Select.Nom = NomText.getText();
            Select.Prenom = PrenomText.getText();
            Select.NumCIN = CINText.getText();
            Select.Disponibility=ComboDisponible.getSelectionModel().getSelectedItem();

            int StokerMoney=Integer.parseInt(MoneyStockerText.getText());
            int solution=StokerMoney+Integer.parseInt(MoneyInStockText.getText());
            Select.MoneyStocker = Integer.parseInt(MoneyStockerText.getText());
            Select.MoneyInStock=solution;
            Select.TypeCompte = ComboTypeText.getSelectionModel().getSelectedItem();
            TableViewAdmin.getItems().set(selectedIndex, Select);

            ServiceClient.Sauvegarder(ClientList);
            CodePINText.setText("");
            NomText.setText("");
            PrenomText.setText("");
            CINText.setText("");
            MoneyInStockText.setText("");
            MoneyStockerText.setText("");
            ComboTypeText.setItems(FXCollections.observableArrayList(""));

            showInfoMessage("La modification de "+ NomText.getText() + " est reussit avec succès");
        }

    }

    @FXML
    void Enregistre_click(ActionEvent event) {
        if (CodePINText.getText().isEmpty() && NomText.getText().isEmpty() && PrenomText.getText().isEmpty() && CINText.getText().isEmpty())
        {
            showInfoMessage("Veuillez bien remplir les renseignements");
            return;
        }
        if(CodePINText.getLength()<4)
        {
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("EXISTANCE");
            alert.setHeaderText(null);
            alert.setContentText("Le code PIN" +CodePINText.getText()+ "est insuffisant \nIl doit avoir quatre chiffre");
            alert.show();
            return;
        }
        int CodePIN=Integer.parseInt(CodePINText.getText());
        String Nom=NomText.getText();
        String Prenom=PrenomText.getText();
        String NumCIN=CINText.getText();
        int MoneyStocker=Integer.parseInt(MoneyStockerText.getText());
        String TypeCompte=ComboTypeText.getSelectionModel().getSelectedItem();
        String NamePhoto=URLPhotoText.getText();

        ClientAdm= new ClientAdmin();
        ClientAdm.Enregistrement(CodePIN, Nom, Prenom, NumCIN, MoneyStocker, TypeCompte, NamePhoto);

        CodePINText.setText("");
        NomText.setText("");
        PrenomText.setText("");
        CINText.setText("");
        MoneyInStockText.setText("");
        MoneyStockerText.setText("");
        ComboTypeText.setItems(FXCollections.observableArrayList(""));

        NumberLab.setText(Integer.toString(ClientList.size()));
        ObservableList<ClasseurClient> list = FXCollections.observableArrayList(ClientList);

        TableViewAdmin.setItems(list);
    }

    @FXML
    void TableViewAdmin_click(ActionEvent event) {

    }

    @FXML
    void supprime_click(ActionEvent event) {

        int selectedIndex = TableViewAdmin.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Supprimer l'élément ?");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet élément ?");

            Optional<ButtonType> result = alert.showAndWait();// Attendre la réponse de l'utilisateur

            if (result.isPresent() && result.get() == ButtonType.OK) {

                ClasseurClient rem = ClientList.get(selectedIndex);
                ClientList.remove(rem);
                ServiceClient.Sauvegarder(ClientList);
                TableViewAdmin.getItems().remove(selectedIndex);
            }
        }
    }

}

