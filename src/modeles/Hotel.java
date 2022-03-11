package modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import services.ServiceChambre;
import services.ServiceHotel;

public class Hotel {

    private int id;
    private int id_responsable;
    private String nom;
    private String address;
//    private Type type = Type.empty;
    private String type;

    private int nb_etoile;
    private int phone;
    private int capacite;
    List<Chambre> list_chambre = new ArrayList<Chambre>();
    // private boolean disponibilite;
    ServiceHotel sH = new ServiceHotel();

    public Hotel() {
    }

    public Hotel(int id) {
        this.id = id;
    }

    public Hotel add() {
        Scanner in = new Scanner(System.in);

        System.out.println("id_responsable= ");
        this.id_responsable = Integer.parseInt(in.nextLine());
        System.out.println("nom= ");
        this.nom = in.nextLine();
        System.out.println("address= ");
        this.address = in.nextLine();
        // System.out.println("type= ");
        // this.type =  in.nextLine();
//        this.type = Type.Hotel;
        System.out.println("nb_etoile= ");
        this.nb_etoile = Integer.parseInt(in.nextLine());
        System.out.println("phone= ");
        this.phone = Integer.parseInt(in.nextLine());
        System.out.println("capacite= ");
        this.capacite = Integer.parseInt(in.nextLine());

        return this;
    }

    public void setChambres() {
        ServiceChambre sC = new ServiceChambre();
        this.list_chambre = sC.getHotel(this);
    }

    public void addChambre(Chambre c) {
        if (this.list_chambre.size() < this.capacite) {
            list_chambre.add(c);
        }
    }

    public void DeleteChambre(Chambre c) {
        list_chambre.remove(c);
    }

    public boolean isDispo() {
        return !this.getChambreDispo().isEmpty();
    }

    public List<Chambre> getChambreDispo() {
        return list_chambre.stream()
                .filter(x -> x.disp)
                .collect(Collectors.toList());
    }

    public Hotel(int id, int id_responsable, String nom, String address, String type, int nb_etoile, int phone,
            int capacite) {
        this.id = id;
        this.id_responsable = id_responsable;
        this.nom = nom;
        this.address = address;
        this.type = type;
        this.nb_etoile = nb_etoile;
        this.phone = phone;
        this.capacite = capacite;
    }

    public Hotel(int id_responsable, String nom, String address, String type, int nb_etoile, int phone, int capacite) {
        this.id_responsable = id_responsable;
        this.nom = nom;
        this.address = address;
        this.type = type;
        this.nb_etoile = nb_etoile;
        this.phone = phone;
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", id_responsable='" + getId_responsable() + "'"
                + ", nom='" + getNom() + "'"
                + ", address='" + getAddress() + "'"
                + ", type='" + getType().toString() + "'"
                + ", nb_etoile='" + getNb_etoile() + "'"
                + ", phone='" + getPhone() + "'"
                + ", capacite='" + getCapacite() + "'"
                + "}";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_responsable() {
        return this.id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return this.type.toString();
    }

    public void setType(String type) {
        this.type = type;
    }

  
    public int getNb_etoile() {
        return this.nb_etoile;
    }

    public void setNb_etoile(int nb_etoile) {
        this.nb_etoile = nb_etoile;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
