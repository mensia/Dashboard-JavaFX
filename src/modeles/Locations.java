/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

/**
 *
 * @author DELL
 */
public class Locations {
    
    private int id;
    private float prix;
    private String date;
    private String destination;
    private String duree;
    private float prix_total;
    
    
    public Locations(int id, float prix, String date, String destination, String duree) {
        this.id = id;
        this.prix = prix;
        this.date = date;
        this.destination = destination;
        this.duree = duree;
    }

    public Locations(float prix, String date, String destination, String duree) {
        this.prix = prix;
        this.date = date;
        this.destination = destination;
        this.duree = duree;
    }

    public Locations(float prix,float prix_total, String date, String destination, String duree) {
        this.prix = prix;
        this.prix_total = prix_total;
        this.date = date;
        this.destination = destination;
        this.duree = duree;
        
    }
    

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }
    

    public Locations() {
        
    }

    public int getId() {
        return id;
    }

    public float getPrix() {
        return prix;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getDuree() {
        return duree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Locations{" + "id=" + id + ", prix=" + prix +",prix_tot= " + prix_total +", date=" + date + ", destination=" + destination + ", duree=" + duree + '}';
    }
    
}
