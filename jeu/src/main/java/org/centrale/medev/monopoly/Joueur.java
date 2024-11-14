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
    private Case position;
    /**
     * Position du joueur sur le plateau
     * Le plateau compte 40 cases
     */
    /**
     * Temps restant immobilisé en prison
     */
    private Integer enPrison;

    /**
     * Constructeur d'un Joueur
     * @param nom Nom du nouveau Joueur
     * @param plateau Plateau lié au nouveau Joueur
     * 
     * On initialise :
     *  - fortune : 100000
     *  - position : 
     *  - enPrison : 0
     */
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

    public Case getPosition() {
        return this.position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public Integer getEnPrison() {
        return this.enPrison;
    }

    public void setEnPrison(Integer enPrison) {
        this.enPrison = enPrison;
    }

    /**
     * Renvoie le nombre de gares possédées par le joueur
     * @return Nombre de gares possédées
     */
    public Integer nbGares() {
        return plateau.nbGares(this);
    }

    /**
     * Effectue le paiement de x au Joueur j
     * @param joueur Joueur à payer
     * @param somme Montant à payer
     */
    public void paiement(Joueur adversaire, Integer somme) {
        
        try{
            if (fortune >= somme){
                        fortune-=somme;
                        adversaire.setFortune(getFortune()+somme);
            }
        }
        catch(NoMoreMoney exc){
            System.out.println("vous n'avez pas assez d'argent");
        }
        
    }

    /**
     * Lance un dé à 6 faces
     * @return 1d6
     */
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }

    /**
     * Fait avancer le Joueur de x cases
     * @param x Nombre de cases
     */
    private void nouvellePos(Integer x) {
        this.setPosition(plateau.avance(this.getPosition(), x));
    }

    /**
     * Gère le tour de jeu d'un Joueur
     */
    public void tourDeJeu() {
        int de = lanceLeDe();
        this.nouvellePos(de);
    }
}
