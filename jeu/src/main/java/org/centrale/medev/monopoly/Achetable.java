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

    public int calculLoyer(){return 0;}

    /**
     * @param j Le joueur arrivé sur la case
     * 
     * Cette action est possible seulement si la case n'a pas encore de proprietaire.
     */
    public void acheter(Joueur j){
        if (j.getFortune() > this.prix){
            j.paiement(this.prix);
            this.proprietaire = j; 
        }   
    }

    @Override
    public String toString(){
        String msg = this.getNom();
        msg = msg + "coût : " + String.valueOf(this.prix) + " - " ;
        if (this.proprietaire == null){
            msg = msg + "sans propriétaire";
        }
        else {
            msg = msg + "propriétaire : " + this.proprietaire.getNom() + " - " + "fortune : " + String.valueOf(this.proprietaire.getFortune()); 
        }
        return msg;
    }
}