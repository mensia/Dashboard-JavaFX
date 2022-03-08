package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package edu.connexion3a2.services;

//import edu.connexion3a2.entities.Transport;
//import edu.connexion3a2.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modeles.Transport;
import utils.DataSource;

/**
 *
 * @author DELL
 */
public class TransportCRUD {
    
     Connection cnx = DataSource.getInstance().getCnx();

    public void ajouterTransport(Transport C) {

        try {
            String requete = "INSERT INTO transport (id,type,num,dispo) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, C.getId());
            pst.setString(2, C.getType());
            pst.setInt(3, C.getNum());
            pst.setInt(4, C.getDispo());

            pst.executeUpdate();
            System.out.println("Transport ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Transport> affichageTransport() {
        List<Transport> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM transport";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet res = pst.executeQuery(requete);

            while (res.next()) {
                Transport C = new Transport();
                C.setId(res.getInt(1));
                C.setType(res.getString(2));
                C.setNum(res.getInt(3));
                C.setDispo(res.getInt(4));
                myList.add(C);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myList;

    }

    public void modifierTransport(Transport C) {
        try {
            String req = "UPDATE transport SET type='" + C.getType() + "', num='" + C.getNum() + "', dispo='" + C.getDispo() + "' WHERE id=" + C.getId();
            PreparedStatement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Transport modifée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerTransport(int id) {
        try {
            String req = "DELETE FROM transport where id=" + id;
            PreparedStatement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Transport supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Transport> RechercheTransport(int id) {
        List<Transport> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM transport where id=" + id;
            PreparedStatement st = cnx.prepareStatement(requete);
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Transport C = new Transport();
                C.setId(res.getInt(1));
                C.setType(res.getString(2));
                C.setNum(res.getInt(3));
                C.setDispo(res.getInt(4));
                myList.add(C);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(myList);
        return myList;

    }

}
