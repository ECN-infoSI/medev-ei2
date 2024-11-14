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

    public int calculLoyer(){

    }

}