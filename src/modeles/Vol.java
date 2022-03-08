package modeles;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import services.ServiceAgence;
import services.ServiceVol_command;

public class Vol {
    private int id;
    private int id_agence;
    private int capacity;
    private int prix;
    private String company;
    private String depart;
    private String destination;
    private Date date;
    List<Vol_command> list_commands = new ArrayList<Vol_command>();

    ServiceAgence sA = new ServiceAgence();
    ServiceVol_command sVc = new ServiceVol_command();

    public Vol add() {
        Scanner in = new Scanner(System.in);

        System.out.println("id_agence= ");
        this.id_agence = Integer.parseInt(in.nextLine());
        System.out.println("capacity= ");
        this.capacity = Integer.parseInt(in.nextLine());
        System.out.println("prix= ");
        this.prix = Integer.parseInt(in.nextLine());
        System.out.println("company= ");
        this.company = in.nextLine();
        System.out.println("depart= ");
        this.depart = in.nextLine();
        System.out.println("destination= ");
        this.destination = in.nextLine();
        System.out.println("date= ");
        this.date = Date.valueOf(in.nextLine());
        return this;
    }

    public Vol() {
    }

    public Vol(int id) {
        this.id = id;
    }

    public Vol(int id_agence, int capacity, int prix, String company, String depart, String destination, Date date) {
        this.id_agence = id_agence;
        this.capacity = capacity;
        this.prix = prix;
        this.company = company;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
    }

    public Vol(int id, int capacity, int prix, int id_agence, String company, String depart, String destination,
            Date date) {
        this.id = id;
        this.id_agence = id_agence;
        this.prix = prix;
        this.capacity = capacity;
        this.company = company;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.list_commands=sVc.getById_vol(this.id);
    }

    public void addVol_command(Vol_command vc) {
        list_commands.add(vc);
    }

    public int calculateReture() {
        return list_commands.size() * prix;
    }

    public List<Vol_command> getList_commands() {
        return sVc.getById_vol(this.id);
    }

    public void setList_commands(List<Vol_command> list_commands) {
        this.list_commands = list_commands;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", id_agence='" + getId_agence() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", prix='" + getPrix() + "'" +
            ", company='" + getCompany() + "'" +
            ", depart='" + getDepart() + "'" +
            ", destination='" + getDestination() + "'" +
            ", date='" + getDate() + "'" +
            ", list_commands='" + getList_commands() +
            "}";
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getId_agence() {
        return this.id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepart() {
        return this.depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
