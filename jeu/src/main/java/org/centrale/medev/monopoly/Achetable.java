/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.medev.monopoly;

/**
 *
 * @author Thomas
 * 
 */
public class Achetable extends Case {
    
    private int prix;
    private Joueur proprietaire;

    public Achetable(){
        super();
        prix = 0;
        proprietaire = null;
    }

    public Achetable(String n, int pos, int p, Joueur j){
        super(n, pos);
        prix = p;
        proprietaire = j;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int calculLoyer(){}

    /**
     * @param j Le joueur arrivé sur la case
     * 
     * Cette action est possible seulement si la case n'a pas encore de proprietaire.
     */
    public void acheter(Joueur j){
        if (j.fortune > this.prix){
            j.paiement(this.prix);
            this.proprietaire = j;    
    }
}