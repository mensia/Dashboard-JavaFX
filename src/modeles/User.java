/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

import Test.SendEmail;
import services.ServiceUser;

/**
 *
 * @author Faty
 */
public class User {
    protected int id;
    protected String nom;
    protected String prenom;
    protected int phone;
    protected String email;
    protected String pwd;
    protected String carte_banq;
    protected Role role;

    ServiceUser sU = new ServiceUser();

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public void resetPassword() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();

        SendEmail mail = new SendEmail(this, "Password reset", "this is your token \n" + token);
        System.out.println("Donner le token");
        Scanner in = new Scanner(System.in);
        String sent = in.nextLine();
        if (sent.equals(token)) {
            System.out.println("Verifier");
            System.out.println("Donner le nouveaux mot de pass");
            String mdp = in.nextLine();
            this.pwd = mdp;
            sU.update(this);
        } else {
            System.out.println("Non Verifier");
        }
    }

    public User(int id, String nom, String prenom, int phone, String email, String pwd, String carte_banq) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.carte_banq = carte_banq;
        this.role = Role.empty;
    }

    public User(String nom, String prenom, int phone, String email, String pwd, String carte_banq) {
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.carte_banq = carte_banq;
        this.role = Role.empty;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nom='" + getNom() + "'" +
                ", prenom='" + getPrenom() + "'" +
                ", phone='" + getPhone() + "'" +
                ", email='" + getEmail() + "'" +
                ", pwd='" + getPwd() + "'" +
                ", carte_banq='" + getCarte_banq() + "'" +
                ", role='" + getRole() + "'" +
                "}";
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCarte_banq() {
        return this.carte_banq;
    }

    public void setCarte_banq(String carte_banq) {
        this.carte_banq = carte_banq;
    }

}
