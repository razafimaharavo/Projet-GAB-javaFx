package com.example.projet_atm;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.projet_atm.HelloApplication.ClientList;
import static com.example.projet_atm.HelloApplication.ServiceClient;

public class HelloController {
    @FXML
    private Label Anglais;
    @FXML
    private Label LabGauche3;
    @FXML
    private ImageView FlagFrench;

    @FXML
    private ImageView FlagMada;

    @FXML
    private ImageView FlagUSA;
    @FXML
    private ImageView CarteRetire;

    @FXML
    private Label BienvenueClient;

    @FXML
    private Button BtnAdmin;

    @FXML
    private Button BtnAnnuler;

    @FXML
    private Button BtnQuitter;

    @FXML
    private Button BtnValider;

    @FXML
    private Button OKGauche0;

    @FXML
    private Button OKGauche1;
    @FXML
    private Label LabGauche2;

    @FXML
    private Button OkDroite_0;

    @FXML
    private Button OkDroite_1;
    @FXML
    private Button OKGauche3;

    @FXML
    private Button OkDroite_3;

    @FXML
    private PasswordField TextFCode;
    @FXML
    private TextField NomText;

    @FXML
    private Label TitleLab;

    @FXML
    private Label francais;

    @FXML
    private Label labGauche0;

    @FXML
    private Label labGauche1;
    @FXML
    public void initialize()
    {
        FlagFrench.setVisible(false);
        FlagMada.setVisible(false);
        FlagUSA.setVisible(false);
        CarteRetire.setVisible(false);

        // Limite le TextField à accepter uniquement des nombres entiers
        TextFCode.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        // Applique une validation personnalisée pour limiter les données à 4 chiffres
        TextFCode.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 4) {
                TextFCode.setText(oldValue);
            }
        });
    }

 @FXML
 void BtnAdmin_click(ActionEvent event) throws IOException{
    /*Stage stage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View_admin.fxml"));
    Scene scene = null;
    try {
     scene = new Scene(fxmlLoader.load());
    } catch (IOException e) {
     throw new RuntimeException(e);
    }
    stage.setTitle("Administrateur");
    stage.setScene(scene);
    stage.show();*/

     Stage stage = (Stage) TextFCode.getScene().getWindow();
     Parent root = FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"));
     stage.setTitle("Administrateur");
     stage.setScene(new Scene(root));

  /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View_admin.fxml"));
  Scene scene = new Scene(fxmlLoader.load());
  stage.setTitle("Administrateur");
  stage.setScene(scene);
  stage.show();*/
 }
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void showInfoMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information sur la retrait");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public int CompteurNext=0;
    public  int countPrev=1;
    public  int OkDroit0=0;
    public int OkGauche=0;
    public boolean ClickBtn=false;
    public boolean retrait=false;
    public int RetireOk=0;
    public boolean MoneyDroit0=false;
    public boolean MoneyDroit1=false;
    public boolean MoneyGauche0=false;
    public boolean MoneyGauche1=false;
    public boolean consulter=false;
    public boolean ConsulterBt=false;
    public boolean AutreMontant=false;
    public  boolean languageFrench=false;
    public  boolean languageEnglish=false;
    public  boolean languageMalagasy=false;
    public int DailyLimit=200000;
    public int DailyLimitPrem=800000;
 @FXML
 void BtnAnnuler_click(ActionEvent event) {
     countPrev--;
     OKGauche0.setVisible(true);
     OKGauche1.setVisible(true);
     OKGauche3.setVisible(true);
     OkDroite_0.setVisible(true);
     OkDroite_1.setVisible(true);
     OkDroite_3.setVisible(true);
     consulter=false;
     ConsulterBt=false;
     AutreMontant=false;
     retrait=false;
     if(countPrev==1)
     {
         TitleLab.setText("Veuillez choisir un language");
         francais.setText("francais");
         Anglais.setText("Anglais");
         labGauche0.setText("Malagasy");
         LabGauche2.setText("");
         FlagFrench.setVisible(true);
         FlagMada.setVisible(true);
         FlagUSA.setVisible(true);
         NomText.setVisible(false);
         languageFrench=false;
         languageMalagasy=false;
         languageEnglish=false;
         CompteurNext=1;
     }
     if(countPrev==2 && languageFrench==true)
     {
         TitleLab.setText("Que vous voulez faire");
         francais.setText("Consulter solder");
         Anglais.setText("Retrait d'argent");
         BtnValider.setDisable(false);
         OkDroit0=1;
         NomText.setVisible(false);
         LabGauche2.setText("");
         labGauche0.setText("");
         CompteurNext=2;
     }
     if(countPrev==2 && languageMalagasy==true)
     {
         TitleLab.setText("Inona no hatao ho anao");
         francais.setText("Hijery sandan-bola");
         Anglais.setText("Haka vola");
         BtnValider.setDisable(false);
         OkDroit0=1;
         NomText.setVisible(false);
         labGauche0.setText("");
         LabGauche2.setText("");
         CompteurNext=2;
     }
     if(countPrev==2 && languageEnglish==true)
     {
         TitleLab.setText("What are you doing?");
         francais.setText("View balance");
         Anglais.setText("Withdrawal money");
         OkDroit0=1;
         BtnValider.setDisable(false);

         NomText.setVisible(false);
         labGauche0.setText("");
         LabGauche2.setText("");
         CompteurNext=2;
     }
     if(countPrev==3 && languageFrench==true)
     {
         TitleLab.setText("Veiullez choisir le montant");
         francais.setText("20000");
         Anglais.setText("40000");
         labGauche0.setText("");
         CompteurNext=3;
     }
     if(countPrev==3 && languageEnglish==true)
     {
         TitleLab.setText("Choose balance");
         francais.setText("20000");
         Anglais.setText("40000");
         labGauche0.setText("");
         CompteurNext=3;
     }
     if(countPrev==3 && languageMalagasy==true)
     {
         TitleLab.setText("Safidio ny sandany tokony halainao");
         francais.setText("20000");
         Anglais.setText("40000");
         labGauche0.setText("");
         CompteurNext=3;
     }

 }

 @FXML
 void BtnQuitter_click(ActionEvent event) {
  Platform.exit();
 }
 public int repeat=0;
 public  int ClientCurrent;
 @FXML
 void BtnValider_click(ActionEvent event) {
     int Existe=0;
     if(CompteurNext==0)
     {
         for (ClasseurClient u : ClientList)
         {
             if (u.getCodePIN()==Integer.parseInt(TextFCode.getText()) && u.getNom().equals(NomText.getText()) && u.getDisponibility().equals("Disponible"))
             {
                 BienvenueClient.setText(u.getPrenom());
                 ClientCurrent=u.getCodePIN();
                 Existe=1;
                 break;
             }
             if (u.getCodePIN()==Integer.parseInt(TextFCode.getText()) && u.getNom().equals(NomText.getText()) && u.getDisponibility().equals("Bloquer"))
             {
                 Alert alert= new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("BLOQUER");
                 alert.setHeaderText(null);
                 alert.setContentText(NomText.getText()+", Votre compte bancaire est bloquer\nVous avez fait 03 tentative d'echèc");
                 alert.show();
                 return;
             }
         }
         if (repeat==3)
         {
             for (ClasseurClient u : ClientList)
             {
                 if (u.getNom().equals(NomText.getText()))
                 {
                     u.Disponibility="Bloquer";
                     ServiceClient.Sauvegarder(ClientList);
                     Alert alert= new Alert(Alert.AlertType.ERROR);
                     alert.setTitle("BLOQUER");
                     alert.setHeaderText(null);
                     alert.setContentText("Votre compte bancaire est bloquer\nVous avez fait 03 tentative d'echèc");
                     alert.show();
                     return;
                 }
             }
         }
         if(Existe==0)
         {
             repeat++;
             Alert alert= new Alert(Alert.AlertType.ERROR);
             alert.setTitle("INCORRECT");
             alert.setHeaderText(null);
             alert.setContentText("Votre mots de passe "+TextFCode.getText() + " est incorrect");
             alert.show();
             return;
         }
     }

     TextFCode.setText("");
     if(RetireOk==1)
     {
         CompteurNext=0;
         countPrev=0;
         BtnValider.setText("Valider");
         CarteRetire.setVisible(false);
         BtnAnnuler.setDisable(false);
         NomText.setVisible(true);
         NomText.setText("");
         NomText.setDisable(false);
         TextFCode.setDisable(false);
         TextFCode.setVisible(true);

         OKGauche0.setVisible(true);
         OKGauche1.setVisible(true);
         OKGauche3.setVisible(true);
         OkDroite_0.setVisible(true);
         OkDroite_1.setVisible(true);
         OkDroite_3.setVisible(true);

         TitleLab.setText("Veuillez entrer votre NOM");
         francais.setText("");
         Anglais.setText("");
         labGauche0.setText("");
         labGauche1.setText("");
         LabGauche3.setText("");
         RetireOk=0;
         return;
     }

     if(ClickBtn==false && CompteurNext!=0 && AutreMontant==false)
     {
         labGauche1.setText("Veuillez selectionner s'il vous plait");
         return;
     }
     else
     {
         labGauche1.setText("");
     }
     CompteurNext++;

     if(CompteurNext!=0)
     {
         BtnValider.setText("Suivant");
     }
     if(CompteurNext==1)
     {
         TitleLab.setText("Veuillez choisir un language");
         francais.setText("francais");
         Anglais.setText("Anglais");
         labGauche0.setText("Malagasy");
         FlagFrench.setVisible(true);
         FlagMada.setVisible(true);
         FlagUSA.setVisible(true);
         TextFCode.setVisible(false);
         NomText.setVisible(false);
         countPrev=1;
     }
     if(CompteurNext==2 && languageFrench==true)
     {
         TitleLab.setText("Que vous voulez faire");
         francais.setText("Consulter solder");
         Anglais.setText("Retrait d'argent");
         labGauche0.setText("");
         FlagFrench.setVisible(false);
         FlagMada.setVisible(false);
         FlagUSA.setVisible(false);
         countPrev=2;
     }
     if(CompteurNext==2 && languageMalagasy==true)
     {
         TitleLab.setText("Inona no hatao ho anao");
         francais.setText("Hijery sandan-bola");
         Anglais.setText("Haka vola");
         FlagFrench.setVisible(false);
         FlagMada.setVisible(false);
         FlagUSA.setVisible(false);
         labGauche0.setText("");
         countPrev=2;
     }
     if(CompteurNext==2 && languageEnglish==true)
     {
         TitleLab.setText("What are you doing?");
         francais.setText("View balance");
         Anglais.setText("Withdrawal money");
         FlagFrench.setVisible(false);
         FlagMada.setVisible(false);
         FlagUSA.setVisible(false);
         labGauche0.setText("");
         countPrev=2;
     }
     if(CompteurNext==3 && retrait==true)
     {
         if(languageFrench) TitleLab.setText("Veuillez choisir le montant");
         if(languageMalagasy) TitleLab.setText("Safidio ny sandany tokony halainao");
         if(languageEnglish) TitleLab.setText("Choose balance");
         for (ClasseurClient u : ClientList)
         {
             if (u.getCodePIN() == ClientCurrent && u.getTypeCompte().equals("Standard")) {
                 francais.setText("20000");
                 Anglais.setText("10000");
                 LabGauche2.setText("40000");
                 labGauche0.setText("80000");
                 if(languageFrench) LabGauche3.setText("Autre montant");
                 if(languageMalagasy) LabGauche3.setText("Sandany hafa");
                 if(languageEnglish) LabGauche3.setText("Other balance");
                 break;
             }
             if (u.getCodePIN() == ClientCurrent && u.getTypeCompte().equals("Premium"))
             {
                 francais.setText("150000");
                 Anglais.setText("100000");
                 LabGauche2.setText("200000");
                 labGauche0.setText("400000");
                 if(languageFrench) LabGauche3.setText("Autre montant");
                 if(languageMalagasy) LabGauche3.setText("Sandany hafa");
                 if(languageEnglish) LabGauche3.setText("Other balance");
                 break;
             }
         }
         retrait=false;
         countPrev=3;
     }
     if(CompteurNext==3 && consulter==true)
     {
         if(languageFrench) TitleLab.setText("Les montants dans votre compte");
         if(languageMalagasy) TitleLab.setText("Ny vola ao anaty stock-nao");
         if(languageEnglish) TitleLab.setText("Your money in the stock");
         for (ClasseurClient u : ClientList)
         {
             if (u.getCodePIN() == ClientCurrent) {
                 NomText.setText(Integer.toString(u.getMoneyInStock()));
                 break;
             }
         }
         francais.setText("");
         Anglais.setText("");
         NomText.setVisible(true);
         NomText.setDisable(true);
         labGauche0.setText("");
         BtnValider.setDisable(true);

         OKGauche0.setVisible(false);
         OKGauche1.setVisible(false);
         OKGauche3.setVisible(false);
         OkDroite_0.setVisible(false);
         OkDroite_1.setVisible(false);
         OkDroite_3.setVisible(false);
         countPrev=3;

     }

     if(CompteurNext==4 && AutreMontant==false)
     {
         for (ClasseurClient u : ClientList)
         {
             LocalDate currentDate = LocalDate.now();
             String DateRetrait=currentDate.toString();

             if(!u.getDatewithdrawal().equals(DateRetrait))
             {
                 u.setWithdrawal(0);
                 u.Datewithdrawal= currentDate.toString();
             }

             if (u.getCodePIN() == ClientCurrent && u.getTypeCompte().equals("Standard"))
             {
                  if (u.getMoneyInStock()<=20000)
                 {
                     if(languageEnglish) showInfoMessage("Your balance reach a condition minimun 10000ar; Your balance: "+u.MoneyInStock+"\nYou can't make a withdrawal if you don't augment your depot");
                     if(languageFrench) showInfoMessage("Votre solde arrive à la condition minimun 10000ar; Votre solde: "+u.MoneyInStock+"\nVous ne pouvez plus faire de retrait si vous n'augmenter pas votre dépot");
                     if(languageMalagasy) showInfoMessage("Efa tonga eo amin'ny sandany farany ambany ny volanao amin'izao (10000ar); Ny volanao: "+u.MoneyInStock+"\nTsy afaka maka intsony enao raha tsy ampinao io vola ao anaty comptinao io");
                     return;
                 }

                 if(MoneyGauche0)
                 {
                     u.withdrawal=u.getWithdrawal()+80000;
                     u.MoneyInStock=u.getMoneyInStock()-80000;

                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimit)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte standard 200000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }
                 if(MoneyGauche1)
                 {
                     u.withdrawal=u.getWithdrawal()+40000;
                     u.MoneyInStock=u.getMoneyInStock()-40000;
                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimit)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte standard 200000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }
                 if(MoneyDroit1)
                 {
                     u.withdrawal=u.getWithdrawal()+20000;
                     u.MoneyInStock=u.getMoneyInStock()-20000;

                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimit)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte standard 200000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }
                 if(MoneyDroit0)
                 {
                     u.withdrawal=u.getWithdrawal()+10000;
                     u.MoneyInStock=u.getMoneyInStock()-10000;
                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimit)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte standard 200000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }


                 ServiceClient.Sauvegarder(ClientList);
                 BienvenueClient.setText("Retrait fait avec succès!");
                 CarteRetire.setVisible(true);
                 RetireOk=1;
                 BtnValider.setText("RETIRER");
                 BtnAnnuler.setDisable(true);
                 break;
             }


             if(u.getCodePIN() == ClientCurrent && u.getTypeCompte().equals("Premium"))
             {
                  if (u.getMoneyInStock()<50000)
                 {
                     if(languageEnglish) showInfoMessage("Your balance reach a condition minimun 50000ar; Your balance: "+u.MoneyInStock+"\nYou can't make a withdrawal if you don't augment your depot");
                     if(languageFrench) showInfoMessage("Votre solde arrive à la condition minimun 50000ar; Votre solde: "+u.MoneyInStock+"\nVous ne pouvez plus faire de retrait si vous n'augmenter pas votre dépot");
                     if(languageMalagasy) showInfoMessage("Efa tonga eo amin'ny sandany farany ambany ny volanao amin'izao (50000ar); Ny volanao: "+u.MoneyInStock+"\nTsy afaka maka intsony enao raha tsy ampinao io vola ao anaty comptinao io");
                     return;
                 }
                 if(MoneyGauche0)
                 {
                     u.withdrawal=u.getWithdrawal()+400000;
                     u.MoneyInStock=u.getMoneyInStock()-400000;

                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimitPrem)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte prémium 800000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }
                 if(MoneyGauche1)
                 {
                     u.withdrawal=u.getWithdrawal()+200000;
                     u.MoneyInStock=u.getMoneyInStock()-200000;
                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimitPrem)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte prémium 800000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }
                 if(MoneyDroit1)
                 {
                     u.withdrawal=u.getWithdrawal()+150000;
                     u.MoneyInStock=u.getMoneyInStock()-150000;

                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimitPrem)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte prémium 800000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }
                 if(MoneyDroit0)
                 {
                     u.withdrawal=u.getWithdrawal()+100000;
                     u.MoneyInStock=u.getMoneyInStock()-100000;
                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimitPrem)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte prémium 800000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);
                 }
                 ServiceClient.Sauvegarder(ClientList);
                 BienvenueClient.setText("Retrait fait avec succès!");
                 CarteRetire.setVisible(true);
                 RetireOk=1;
                 BtnValider.setText("RETIRER");
                 BtnAnnuler.setDisable(true);
                 //labGauche1.setText("Veuillez retirer la carte");
                 break;
             }
         }
         francais.setText("");
         Anglais.setText("");
         labGauche0.setText("");
         LabGauche2.setText("");
         NomText.setVisible(true);
         NomText.setDisable(true);
         countPrev=4;
         CompteurNext=-1;
     }

     if(CompteurNext==4 && AutreMontant==true)
     {
         for (ClasseurClient u : ClientList)
         {
             LocalDate currentDate = LocalDate.now();
             String DateRetrait=currentDate.toString();

             if(!u.getDatewithdrawal().equals(DateRetrait))
             {
                 u.setWithdrawal(0);
                 u.Datewithdrawal= currentDate.toString();
             }

             if (u.getCodePIN() == ClientCurrent && u.getTypeCompte().equals("Standard"))
             {
                 int MoneyRetirer=Integer.parseInt(NomText.getText());
                 if(MoneyRetirer>=10000 && MoneyRetirer % 5000==0) {

                     u.MoneyInStock = u.getMoneyInStock() - MoneyRetirer;
                     u.withdrawal=u.getWithdrawal()+MoneyRetirer;
                     //u.MoneyInStock=u.getMoneyInStock()-100000;
                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimit)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte standard 200000 ar. Votre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);

                     ServiceClient.Sauvegarder(ClientList);
                     BienvenueClient.setText("Retrait fait avec succès!");
                     CarteRetire.setVisible(true);
                     NomText.setText("");
                     RetireOk=1;
                     BtnValider.setText("RETIRER");
                     BtnAnnuler.setDisable(true);
                     break;
                 }
                 else
                     {
                         CompteurNext=3;
                         Alert alert= new Alert(Alert.AlertType.ERROR);
                         if (languageFrench) alert.setTitle("INSUFFISANT");
                         if (languageMalagasy) alert.setTitle("TSY FAHAMPINA");
                         if (languageEnglish) alert.setTitle("INSUFFISANT");
                         alert.setHeaderText(null);
                         if(languageFrench) alert.setContentText("Assurer vous que l'argent ("+ NomText.getText()+" ar) que vous voulez retirer est supérieur à 10000 ar\nSinon verifie que votre argent contient les norme d'argent.\nNorme: 5000ar 10000ar 20000ar");
                         if(languageMalagasy) alert.setContentText("Hamarino ny vola ("+ NomText.getText()+" ar) raha ambony noho ny 10000 ar\nRaha tsy izay dia hamarino raha manaraka ny laoniny ilay vola.\nLaoniny: 5000ar 10000ar 20000ar");
                         if(languageEnglish) alert.setContentText("Are you sure that ("+ NomText.getText()+" ar) is superieur of 10000 ar\nElse verify that your money has the money norme.\nNorme: 5000ar 10000ar 20000ar");
                         alert.show();
                         return;
                     }
             }
             if(u.getCodePIN() == ClientCurrent && u.getTypeCompte().equals("Premium"))
             {
                 int MoneyRetirer=Integer.parseInt(NomText.getText());
                 if(MoneyRetirer>=50000 && MoneyRetirer % 5000==0)
                 {
                     u.MoneyInStock=u.getMoneyInStock()-MoneyRetirer;
                     u.withdrawal=u.getWithdrawal()+MoneyRetirer;
                     //u.MoneyInStock=u.getMoneyInStock()-100000;
                     if(u.getDatewithdrawal().equals(DateRetrait) && u.withdrawal > DailyLimitPrem)
                     {
                         showErrorMessage("Vous avez dépassez la limite du retrait du compte prémium 800000 ar\n\tVotre retrait "+u.getWithdrawal());
                         return;
                     }
                     showInfoMessage("La somme de retrait que vous avez faire aujourd'hui est "+u.withdrawal);

                     ServiceClient.Sauvegarder(ClientList);
                     BienvenueClient.setText("Retrait fait avec succès!");
                     CarteRetire.setVisible(true);
                     RetireOk=1;
                     BtnValider.setText("RETIRER");
                     BtnAnnuler.setDisable(true);
                     break;
                 }
                 else
                 {
                     CompteurNext=3;
                     Alert alert= new Alert(Alert.AlertType.ERROR);
                     if (languageFrench) alert.setTitle("INSUFFISANT");
                     if (languageMalagasy) alert.setTitle("TSY FAHAMPINA");
                     if (languageEnglish) alert.setTitle("INSUFFISANT");
                     alert.setHeaderText(null);
                     if (languageFrench) alert.setContentText("Assurer vous que l'argent ("+ NomText.getText()+" ar) que vous voulez retirer est supérieur à 50000 ar\nSinon verifie que votre argent contient les norme d'argent.\nNorme: 5000ar 10000ar 20000ar");
                     if(languageMalagasy) alert.setContentText("Hamarino ny vola ("+ NomText.getText()+" ar) raha ambony noho ny 50000 ar\nRaha tsy izay dia hamarino raha manaraka ny laoniny ilay vola.\nLaoniny: 5000ar 10000ar 20000ar");
                     if(languageEnglish) alert.setContentText("Are you sure that ("+ NomText.getText()+" ar) is superieur of 50000 ar\nElse verify that your money has the money norme.\nNorme: 5000ar 10000ar 20000ar");
                     alert.show();
                     return;
                 }

             }
         }
         francais.setText("");
         Anglais.setText("");
         labGauche0.setText("");
         LabGauche2.setText("");
         NomText.setVisible(true);
         NomText.setDisable(true);
         languageEnglish=false;
         languageFrench=false;
         languageMalagasy=false;
         countPrev=4;
         CompteurNext=-1;
     }

     Anglais.setOpacity(1);
     francais.setOpacity(1);
     labGauche0.setOpacity(1);
     ClickBtn=false;
     OKGauche0.setDisable(false);
     OkDroite_0.setDisable(false);
     OkDroite_1.setDisable(false);
     OKGauche1.setDisable(false);
     OKGauche3.setDisable(false);
     OkDroite_3.setDisable(false);

     OKGauche0.setOpacity(1);
     OkDroite_0.setOpacity(1);
     OkDroite_1.setOpacity(1);
     OKGauche1.setOpacity(1);
     OKGauche3.setOpacity(1);
     OkDroite_3.setOpacity(1);
 }
    @FXML
    void OKGauche0_click(ActionEvent event) {
        ClickBtn=true;
        OkGauche++;
        OkDroit0++;
        if(OkGauche==1) {
            languageMalagasy = true;
            languageEnglish = false;
            languageFrench = false;
            labGauche0.setOpacity(0.5);
            Anglais.setOpacity(1);
            francais.setOpacity(1);
        }
        if(OkGauche==2)
        {
            MoneyDroit0=false;
            MoneyDroit1=false;
            MoneyGauche0=true;
            MoneyGauche1=false;
            labGauche0.setOpacity(0.5);
            LabGauche2.setOpacity(1);
            Anglais.setOpacity(1);
            francais.setOpacity(1);
            OkGauche=0;
        }
        if(OkDroit0==3)
        {
            MoneyDroit0=false;
            MoneyDroit1=false;
            MoneyGauche0=true;
            MoneyGauche1=false;
            labGauche0.setOpacity(0.5);
            LabGauche2.setOpacity(1);
            Anglais.setOpacity(1);
            francais.setOpacity(1);
            OkGauche=0;
        }

        OKGauche0.setOpacity(0.2);
        OKGauche0.setDisable(true);
        OkDroite_0.setDisable(true);
        OKGauche1.setDisable(true);
        OkDroite_1.setDisable(true);
        OKGauche3.setDisable(true);
        OkDroite_3.setDisable(true);
    }

    @FXML
    void OKGauche1_click(ActionEvent event) {
        ClickBtn=true;
        OkGauche=1;

        MoneyDroit0=false;
        MoneyDroit1=false;
        MoneyGauche0=false;
        MoneyGauche1=true;
        labGauche0.setOpacity(1);
        LabGauche2.setOpacity(0.5);
        Anglais.setOpacity(1);
        francais.setOpacity(1);
    }

    @FXML
    void OkDroite_0_click(ActionEvent event) {
     ClickBtn=true;
     OkDroit0++;
     if(OkDroit0==1)
     {
         languageEnglish=true;
         languageFrench=false;
         languageMalagasy=false;
         Anglais.setOpacity(0.5);
         francais.setOpacity(1);
         labGauche0.setOpacity(1);
     }
     if(OkDroit0==2)
     {
        retrait=true;
        consulter=false;
         Anglais.setOpacity(0.5);
         francais.setOpacity(1);
         labGauche0.setOpacity(1);
        //OkDroit0=0;
     }
        if(OkDroit0==3)
        {
            MoneyDroit0=true;
            MoneyDroit1=false;
            MoneyGauche0=false;
            MoneyGauche1=false;
            Anglais.setOpacity(0.5);
            francais.setOpacity(1);
            labGauche0.setOpacity(1);
            LabGauche2.setOpacity(1);
            OkDroit0=0;
        }
        OkDroite_0.setOpacity(0.2);
        OKGauche0.setDisable(true);
        OkDroite_0.setDisable(true);
        OKGauche1.setDisable(true);
        OkDroite_1.setDisable(true);
        OKGauche3.setDisable(true);
        OkDroite_3.setDisable(true);

    }

    @FXML
    void OkDroite_1_click(ActionEvent event) {
        ClickBtn=true;
        OkDroit0++;
        if(OkDroit0==1)
        {
            languageFrench=true;
            languageMalagasy=false;
            languageEnglish=false;
            francais.setOpacity(0.5);
            Anglais.setOpacity(1);
            labGauche0.setOpacity(1);
        }
        if(OkDroit0==2)
        {
            consulter=true;
            retrait=false;
            francais.setOpacity(0.5);
            Anglais.setOpacity(1);
            labGauche0.setOpacity(1);
            ConsulterBt=true;
            //OkDroit0=0;
        }
        if(OkDroit0==3)
        {
            MoneyDroit0=false;
            MoneyDroit1=true;
            MoneyGauche0=false;
            MoneyGauche1=false;
            francais.setOpacity(0.5);
            Anglais.setOpacity(1);
            labGauche0.setOpacity(1);
            LabGauche2.setOpacity(1);
            OkDroit0=0;
        }
        OkDroite_1.setOpacity(0.2);
        OKGauche0.setDisable(true);
        OkDroite_0.setDisable(true);
        OKGauche1.setDisable(true);
        OkDroite_1.setDisable(true);
        OKGauche3.setDisable(true);
        OkDroite_3.setDisable(true);

    }

    @FXML
    void OKGauche3_click(ActionEvent event) {
        AutreMontant=true;

        NomText.setVisible(true);
        NomText.setDisable(false);
        francais.setText("");
        Anglais.setText("");
        LabGauche2.setText("");
        labGauche0.setText("");
        LabGauche3.setText("");
        OKGauche0.setVisible(false);
        OKGauche1.setVisible(false);
        OKGauche3.setVisible(false);
        OkDroite_0.setVisible(false);
        OkDroite_1.setVisible(false);
        OkDroite_3.setVisible(false);
        if(languageEnglish) TitleLab.setText("Enter your sum");
        if (languageFrench) TitleLab.setText("Entrer le montant");
        if (languageMalagasy) TitleLab.setText("Ampidiro ny sandam-bola");
    }
    @FXML
    void OkDroite_3_click(ActionEvent event) {

    }

    @FXML
    void Zero_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"0");
    }
    @FXML
    void Un_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"1");
    }
    @FXML
    void Deux_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"2");
    }
    @FXML
    void Trois_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"3");
    }
    @FXML
    void Quatre_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"4");
    }
    @FXML
    void Cinq_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"5");
    }
    @FXML
    void Six_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"6");
    }

    @FXML
    void Sept_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"7");
    }
    @FXML
    void Huite_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"8");
    }

    @FXML
    void Neuf_click(ActionEvent event) {
        TextFCode.setText(TextFCode.getText()+"9");
    }
    @FXML
    void Delete_click(ActionEvent event) {
        String chaine = TextFCode.getText();
        if (chaine.length()!=0){
            String newChaine = chaine.substring(0, chaine.length() - 1);
            TextFCode.setText(newChaine);
        }
    }
    @FXML
    void CE_click(ActionEvent event) {
        TextFCode.setText("");
    }

    @FXML
    void TextFCode_click(ActionEvent event) {

    }

}

