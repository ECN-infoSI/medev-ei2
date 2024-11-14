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
    private String nom;
    private Integer fortune;
    private Plateau plateau;
    private Integer position;
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
