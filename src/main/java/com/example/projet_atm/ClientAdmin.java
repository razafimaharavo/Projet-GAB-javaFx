package com.example.projet_atm;

import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.projet_atm.HelloApplication.ClientList;
import static com.example.projet_atm.HelloApplication.ServiceClient;

public class ClientAdmin {
    void Enregistrement(int CodePIN, String Nom, String Prenom, String NumCIN, int MoneyStocker, String TypeCompte, String NamePhoto){
        ClasseurClient Client= new ClasseurClient();
        Client.setCodePIN(CodePIN);
        Client.setNom(Nom);
        Client.setPrenom(Prenom);
        Client.setNumCIN(NumCIN);

        Client.setPhoto("C:\\Users\\Brunel\\IdeaProjects\\Projet_ATM\\PhotoRecent\\"+NamePhoto);
        Client.setDatewithdrawal("Date_null");
        Client.setWithdrawal(0);
        if(MoneyStocker>=10000 && TypeCompte.equals("Standard"))
        {
            Client.setMoneyStocker(MoneyStocker);
            Client.setTypeCompte(TypeCompte);
            for (ClasseurClient u : ClientList)
            {
                if (u.getCodePIN()==Client.getCodePIN())
                {
                    Alert alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("EXISTANCE");
                    alert.setHeaderText(null);
                    alert.setContentText(Nom + " est déjà exister");
                    alert.show();
                    return;
                }
            }
        }
        else if (MoneyStocker<=10000 && TypeCompte.equals("Standard"))
        {
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Stockage insuffisant");
            alert.setHeaderText(null);
            alert.setContentText("L'argent que vous entrer "+MoneyStocker+ " est inferieur à 10000 ar\n Il doit être superieur à 10000 ar");
            alert.show();

            return;
        }

        else if(MoneyStocker>=50000 && TypeCompte.equals("Premium"))
        {
            Client.setMoneyStocker(MoneyStocker);
            Client.setTypeCompte(TypeCompte);
            for (ClasseurClient u : ClientList)
            {
                if (u.getCodePIN()==Client.getCodePIN())
                {
                    Alert alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("EXISTANCE");
                    alert.setHeaderText(null);
                    alert.setContentText(Nom + " est déjà exister");
                    alert.show();
                    return;
                }
            }
        }
        else
        {
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Stockage insuffisant");
            alert.setHeaderText(null);
            alert.setContentText("L'argent que vous entrer est "+MoneyStocker+" inferieur à 50000 ar\n Il doit être superieur à 10000 ar");
            alert.show();

            return;
        }
        Client.setMoneyInStock(MoneyStocker);
        LocalDate date = LocalDate.now();
        Client.setSavingDate(date.toString());
        Client.setDisponibility("Disponible");
        ClientList.add(Client);
        ServiceClient.Sauvegarder(ClientList);

        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successfull");
        alert.setHeaderText(null);
        alert.setContentText("L'enregistrement de "+Nom + " est reussit avec succès");
        alert.show();

    }

    void recherche(String nom)
    {
            ArrayList<ClasseurClient> founds = new ArrayList<>();
            for(int i=0; i<ClientList.size(); i++)
            {
                ClasseurClient current=ClientList.get(i);
                if (current.getNom().contains(nom)){
                    founds.add(current);
                }
            }
            System.out.println("Resultat Recherche : ");
            /*if (founds.size() > 0)
            {
                for (int i = 0; i < founds.size(); i++) {
                    System.out.println("Id: "+founds.get(i).getIdLivre()+"|\tTitre :" + founds.get(i).getTitre()+"|\tEtat: "+founds.get(i).getEtatLivre()+"|\t Nombre d'outil : " +
                            founds.get(i).getNombreLivre()+"|\t Nom d'Auteur : "+founds.get(i).getNomAuteurLivre()+"|\tPrénom d'Auteur: "+founds.get(i).getPrenomAuteurLivre()+"|\tFaculter correspondant: "+founds.get(i).getFaculterBook()+"|\tcôte de livre: "+founds.get(i).getCote()+" |\t la date de publication: "+founds.get(i).getDatePublication());
                }
            }
            else {
                System.out.println("Nothing found");
            }*/
        }

}
