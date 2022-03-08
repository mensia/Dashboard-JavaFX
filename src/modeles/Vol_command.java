package modeles;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import services.ServiceAgence;
import services.ServiceVol;
import services.ServiceVol_command;

public class Vol_command {
    private int id;
    private int id_user;
    private int id_agance;
    private int id_vol;
    private int prix;

    public Vol_command() {
    }

    public Vol_command(int id) {
        this.id = id;
    }


    public Vol_command(int id, int id_user, int id_agance, int id_vol, int prix) {
        this.id = id;
        this.id_user = id_user;
        this.id_agance = id_agance;
        this.id_vol = id_vol;
        this.prix = prix;
    }
    
    public Vol_command add() {
        Scanner in = new Scanner(System.in);

        ServiceAgence sA = new ServiceAgence();
        ServiceVol_command sVc = new ServiceVol_command();
        ServiceVol sV = new ServiceVol();

        sA.getAll().forEach(x -> System.out.println(x));
        System.out.println("Donner l'id");
        int id = Integer.parseInt(in.nextLine());

        Agence a = (Agence) sA.getById(id);

        List<Vol> vols = sV.getByIdAgence(a.getId());
        vols.forEach(x -> System.out.println(x));
        System.out.println("Donner l'id");
        id = Integer.parseInt(in.nextLine());
        
        Vol v = (Vol) sV.getById(id);
        
        List<Vol_command> volsc = v.getList_commands();
        if (volsc.size() == v.getCapacity()) {
            System.out.println("Vol complet");
        } else {
            System.out.println("Vol commander ;-) ");
            this.id_agance = a.getId();
            this.id_vol = v.getId();
            this.id_user = 0;
            this.prix = v.getPrix();
        }

        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", id_user='" + getId_user() + "'" +
                ", id_agance='" + getId_agance() + "'" +
                ", id_vol='" + getId_vol() + "'" +
                "}";
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return this.id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_agance() {
        return this.id_agance;
    }

    public void setId_agance(int id_agance) {
        this.id_agance = id_agance;
    }

    public int getId_vol() {
        return this.id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

}
