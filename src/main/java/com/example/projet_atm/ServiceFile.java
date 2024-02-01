package com.example.projet_atm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceFile<T> {
    private String filename;
    private Class<T> clazz;
    public ServiceFile(String filename,Class<T> clazz){
        this.filename=filename;
        this.clazz=clazz;
        File file=new File(this.filename);
        if(!file.exists()){
            try{
                file.createNewFile();
            }
            catch (IOException e){
                System.out.println("Erreur pendant la création du fichier");
            }
        }
    }

    public void Sauvegarder(List<T> collection){
        try{
            FileWriter writer=new FileWriter(this.filename, false);//Ecrire du nouveau et remplacer (Supprimer) tout ce qui est déjà exister
            for(T data : collection){
                writer.write(data.toString()+"\n");
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("An error occured");
        }
    }
    T creerInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException{//fdug
        return clazz.newInstance();
    }
    public void Charger(List<T> collection){
        try{
            File file=new File(this.filename);
            Scanner scan=new Scanner(file);
            while(scan.hasNextLine()){

                String text=scan.nextLine();// string text prend tout le ligne qui a le ligne suivant

                try {
                    T donnee=this.creerInstance(clazz);// tsyfantatr donnee=new tsyfantatr
                    IClass ic_donnee=(IClass)donnee;//le type implement sur l'interface mais dans l'interface que IClass exist, donc il est obligé de se castinisé pour q'il a le fonction parse
                    ic_donnee.Parse(text);//parser le texte dans le type (miantso fonction)

                    collection.add(donnee);

                } catch (InstantiationException ex) {
                    Logger.getLogger(ServiceFile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ServiceFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException e){
            System.out.println("Erreur lors du chargement");
        }
    }

}
