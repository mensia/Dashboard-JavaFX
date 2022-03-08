package services;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package edu.connexion3a2.services;

//import edu.connexion3a2.entities.Locations;
import java.sql.Connection;
import java.util.List;

/**
 *  
 * @author DELL
 */
//import edu.connexion3a2.entities.Locations;
// import edu.connexion3a2.utils.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modeles.Locations;
import utils.DataSource;

/**
 *
 * @author MSI
 */
public class LocationsCRUD {
    Connection cnx = DataSource.getInstance().getCnx();

    public void ajouterLocations(Locations C) {

        try {
            String requete = "INSERT INTO locations (prix,prix_total,date,destination,duree,id_prop) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
           // pst.setInt(1, C.getId());
            pst.setFloat(1, C.getPrix());
             pst.setFloat(2, C.getPrix_total());
            pst.setString(3, C.getDate());
            pst.setString(4, C.getDestination());
            pst.setInt(5, C.getDuree());
            pst.setInt(6, C.getId_prop());

            pst.executeUpdate();
            System.out.println("Location ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List affichageLocations() {
        List<Locations> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM `Locations` ";
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Locations C = new Locations();
                C.setId(res.getInt(1));
                C.setPrix(res.getFloat(2));
                C.setDate(res.getString(3));
                C.setDestination(res.getString(4));
                C.setDuree(res.getInt(5));
                C.setId_prop(res.getInt(6)); 
                myList.add(C);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void modifierLocations(Locations C) {
        try {
            String req = "UPDATE locations SET prix='" + C.getPrix() + "', date='" + C.getDate() + "', destination='" + C.getDestination() + "', duree='" + C.getDuree() + "' WHERE id=" + C.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Location modifée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerLocations(int id) {
        try {
            String req = "DELETE FROM locations where id=" + id;
           Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Location supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void calculPrixTot() {
        List<String> prixL = new ArrayList<>();
        List<String> id = new ArrayList<>();

        String query = "SELECT `id`,`prix`, `duree` FROM `locations`";
        

        double prix_tot = 0;
        List<String> duree = new ArrayList<>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                prixL.add(rs.getString("prix"));
                duree.add(rs.getString("duree"));
                id.add(rs.getString("id"));
                for (int i = 0; i < prixL.size(); i++) {
                    prix_tot=Integer.parseInt(prixL.get(i))*Integer.parseInt(duree.get(i));
                    String queryy = "UPDATE `locations` SET `prix_total`='"+prix_tot+"' WHERE id="+id.get(i);
                    Statement st1 = cnx.createStatement();
                    st1.executeUpdate(queryy);
                    System.out.println("prix total = "+prix_tot);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       // System.out.println(prixL + " " + duree + " " + id);
    }

}
