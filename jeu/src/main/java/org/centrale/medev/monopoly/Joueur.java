/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly;

/**
 *
 * @author hanss
 */
public class Joueur {
    /**
     * Nom du joueur
     */
    private String nom;
    /**
     * Fortune du joueur
     */
    private Integer fortune;
    /**
     * Plateau associé au joueur
     */
    private Plateau plateau;
    /**
     * Position du joueur sur le plateau
     * Le plateau compte 40 cases
     */
    private Integer position;
    /**
     * Temps restant immobilisé en prison
     */
    private Integer enPrison;

    public Joueur(String nom, Plateau plateau) {
        this.nom = nom;
        this.fortune = 100000;
        this.plateau = plateau;
        this.position = 0;
        this.enPrison = 0;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getFortune() {
        return this.fortune;
    }

    public void setFortune(Integer fortune) {
        this.fortune = fortune;
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getEnPrison() {
        return this.enPrison;
    }

    public void setEnPrison(Integer enPrison) {
        this.enPrison = enPrison;
    }


    public Integer nbGares() {
        return plateau.nbGares(this);
    }

    public void paiement(Joueur j, Integer x) {

    }

    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }

    private void nouvellePos(Integer x) {
        this.setPosition((this.getPosition() + x)%40);
    }

    public void tourDeJeu() {
        int de = lanceLeDe();
        this.nouvellePos(de);
    }
}
