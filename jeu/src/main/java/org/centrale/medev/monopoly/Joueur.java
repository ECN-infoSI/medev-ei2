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

    public Integer nbGares() {

    }

    public void paiement(Joueur j, Integer x) {

    }

    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }

    public void tourDeJeu() {
        
    }
}
