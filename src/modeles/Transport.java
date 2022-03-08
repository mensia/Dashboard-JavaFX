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
public class Transport {
    
    private int id;
    private String type;
    private int dispo;
    private int num;
    private int id_prop ; 

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }
    
        public Transport() {
        
    }
        public Transport(int id, String type, int num, int dispo) {
        this.id = id;
        this.type = type;
        this.dispo = dispo;
        this.num = num;
    }
        
        public Transport(String type, int num, int dispo) {
        this.type = type;
        this.dispo = dispo;
        this.num = num;
    }
        
    
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDispo() {
        return dispo;
    }

    public int getNum() {
        return num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Transport{" + "id=" + id + ", type=" + type + ", dispo=" + dispo + ", num=" + num + '}';
    }
    
}
