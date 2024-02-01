package com.example.projet_atm;

public class ClasseurClient implements IClass{
    public int CodePIN;//code +
    public String Nom;
    public String Prenom;
    public String NumCIN;
    public int MoneyInStock;
    public int MoneyStocker;
    public String SavingDate;
    public String TypeCompte;
    public  String Disponibility;
    public String Photo;
    public String Datewithdrawal;
    public int withdrawal;

    public int getCodePIN() {
        return CodePIN;
    }

    public void setCodePIN(int codePIN) {
        CodePIN = codePIN;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNumCIN() {
        return NumCIN;
    }

    public void setNumCIN(String numCIN) {
        NumCIN = numCIN;
    }

    public int getMoneyInStock() {
        return MoneyInStock;
    }

    public void setMoneyInStock(int moneyInStock) {
        MoneyInStock = moneyInStock;
    }

    public int getMoneyStocker() {
        return MoneyStocker;
    }

    public void setMoneyStocker(int moneyStocker) {
        MoneyStocker = moneyStocker;
    }

    public String getSavingDate() {
        return SavingDate;
    }

    public void setSavingDate(String savingDate) {
        SavingDate = savingDate;
    }

    public String getTypeCompte() {
        return TypeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        TypeCompte = typeCompte;
    }

    public String getDisponibility() {
        return Disponibility;
    }

    public void setDisponibility(String disponibility) {
        Disponibility = disponibility;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getDatewithdrawal() {
        return Datewithdrawal;
    }

    public void setDatewithdrawal(String datewithdrawal) {
        Datewithdrawal = datewithdrawal;
    }

    public int getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(int withdrawal) {
        this.withdrawal = withdrawal;
    }

    @Override
    public String toString(){
        return this.CodePIN+";"+this.Nom+";"+this.Prenom+";"+this.NumCIN+";"+this.MoneyInStock+";"+this.MoneyStocker+";"+this.SavingDate+";"+this.TypeCompte+";"+this.Disponibility+";"+this.Photo+";"+this.Datewithdrawal+";"+this.withdrawal;
    }

    @Override
    public void Parse(String text) {
        String data[]=text.split(";");
        this.CodePIN=Integer.parseInt(data[0]);
        this.Nom=data[1];
        this.Prenom=data[2];
        this.NumCIN=data[3];
        this.MoneyInStock=Integer.parseInt(data[4]);
        this.MoneyStocker=Integer.parseInt(data[5]);
        this.SavingDate=data[6];
        this.TypeCompte=data[7];
        this.Disponibility=data[8];
        this.Photo=data[9];
        this.Datewithdrawal=data[10];
        this.withdrawal=Integer.parseInt(data[11]);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
