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

    public Gare(string n, int pos, int p, Joueur j){
        super(n, pos, p, j);
    }

    public int calculLoyer(){
        if !(proprietaire == null){
            return baseLoyer*proprietaire.nbGares();
        } else {
            return 0;
        }
    }
}