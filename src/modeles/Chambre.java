package modeles;

import java.util.Objects;

public class Chambre {
    int id;
    int id_hotel;
    int number;
    int prix;
    String image;
    String description;
    boolean disp;

    public Chambre() {
    }

    public Chambre(int id) {
        this.id = id;
    }

    public void reserve(){
        this.disp=!this.disp;
    }

    public Chambre(int id_hotel, int number, int prix, String image, String description, boolean disp) {
        this.id_hotel = id_hotel;
        this.number = number;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.disp = disp;
    }

    public Chambre(int id, int id_hotel, int number, int prix, String image, String description, boolean disp) {
        this.id = id;
        this.id_hotel = id_hotel;
        this.number = number;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.disp = disp;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_hotel() {
        return this.id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisp() {
        return this.disp;
    }

    public boolean getDisp() {
        return this.disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Chambre)) {
            return false;
        }
        Chambre chambre = (Chambre) o;
        return id == chambre.id && id_hotel == chambre.id_hotel && number == chambre.number && prix == chambre.prix
                && Objects.equals(image, chambre.image) && Objects.equals(description, chambre.description)
                && disp == chambre.disp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_hotel, number, prix, image, description, disp);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", id_hotel='" + getId_hotel() + "'" +
                ", number='" + getNumber() + "'" +
                ", prix='" + getPrix() + "'" +
                ", image='" + getImage() + "'" +
                ", description='" + getDescription() + "'" +
                ", disp='" + isDisp() + "'" +
                "}";
    }

}
