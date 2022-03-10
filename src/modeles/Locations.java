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
    private int duree;
    private float prix_total;
    private int id_prop ; 
    private int id_transport ; 

    public int getId_transport() {
        return id_transport;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }
    
    
    public Locations(int id, float prix, String date, String destination, int duree , int id_prop , int id_transport ) {
        this.id = id;
        this.prix = prix;
        this.date = date;
        this.destination = destination;
        this.duree = duree;
        this.id_prop = id_prop ;
        this.id_transport = id_transport ; 
    }

    public Locations(float prix, String date, String destination, int duree , int id_prop , int id_transport ) {
        this.prix = prix;
        this.date = date;
        this.destination = destination;
        this.duree = duree;
        this.id_prop = id_prop ;
        this.id_transport = id_transport ; 
    
    }

    public Locations(float prix,float prix_total, String date, String destination, int duree , int id_prop , int id_transport ) {
        this.prix = prix;
        this.prix_total = prix_total;
        this.date = date;
        this.destination = destination;
        this.duree = duree;
        this.id_prop = id_prop ;
        this.id_transport = id_transport ; 
    
        
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

    public int getDuree() {
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

    public void setDuree(int duree) {   
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Locations{" + "id=" + id + ", prix=" + prix +",prix_tot= " + prix_total +", date=" + date + ", destination=" + destination + ", duree=" + duree + '}';
    }
    
}
