package modeles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import services.ServiceReservation;

public class Reservation {
    private int id;
    private int id_user;
    private int id_hotel;
    private int prix;
    private LocalDate entree;
    private LocalDate sortie;
    private int num_chambre;
    private String description;

    ServiceReservation sR = new ServiceReservation();

    public Reservation() {
    }

    public Reservation(int id) {
        this.id = id;
    }

    public List<Reservation> Tri() {
        List<Reservation> list = sR.getAll();
        return list.stream()
                .sorted(((o1, o2) -> o1.getPrix() - o2.getPrix()))
                .collect(Collectors.toList());

    }

    public List<Reservation> Chercher(String s) {
        List<Reservation> list = sR.getAll();
        return list.stream()
                .filter(o -> o.getDescription().contains(s))
                .collect(Collectors.toList());

    }


    public Reservation(int id_user, int id_hotel, int prix, LocalDate entree, LocalDate sortie, int num_chambre,
            String description) {
        this.id_user = id_user;
        this.id_hotel = id_hotel;
        this.prix = prix;
        this.entree = entree;
        this.sortie = sortie;
        this.num_chambre = num_chambre;
        this.description = description;
    }

    public Reservation(int id, int id_user, int id_hotel, int prix, LocalDate entree, LocalDate sortie, int num_chambre,
            String description) {
        this.id = id;
        this.id_user = id_user;
        this.id_hotel = id_hotel;
        this.prix = prix;
        this.entree = entree;
        this.sortie = sortie;
        this.num_chambre = num_chambre;
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", id_user='" + getId_user() + "'" +
                ", id_hotel='" + getId_hotel() + "'" +
                ", prix='" + getPrix() + "'" +
                ", entree='" + getEntree() + "'" +
                ", sortie='" + getSortie() + "'" +
                ", num_chambre='" + getNum_chambre() + "'" +
                ", description='" + getDescription() + "'" +
                "}";
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

    public int getId_hotel() {
        return this.id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public LocalDate getEntree() {
        return this.entree;
    }

    public void setEntree(LocalDate entree) {
        this.entree = entree;
    }

    public LocalDate getSortie() {
        return this.sortie;
    }

    public void setSortie(LocalDate sortie) {
        this.sortie = sortie;
    }

    public int getNum_chambre() {
        return this.num_chambre;
    }

    public void setNum_chambre(int num_chambre) {
        this.num_chambre = num_chambre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
