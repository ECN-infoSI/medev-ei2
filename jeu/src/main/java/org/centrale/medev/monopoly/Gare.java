/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.medev.monopoly;

/**
 *
 * @author Thomas
 * 
 */
public class Gare extends Achetable {

    final int baseLoyer = 2500; 

    public Gare(){
        super();
    }

    public Gare(String n, int pos, int p, Joueur j){
        super(n, pos, p, j);
    }

    /**
     *  
     */
    public int calculLoyer(){
        if (this.getProprietaire() == null){
            return baseLoyer*this.getProprietaire().nbGares();
        } else {
            return 0;
        }
    }
}