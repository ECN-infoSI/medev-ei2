/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.medev.monopoly;

/**
 *
 * @author Thomas
 * 
 */
public class Compagnie extends Achetable {

    public Compagnie(){
        super();
    }

    public Compagnie(String n, int pos, int p, Joueur j){
        super(n, pos, p, j);
    }

    public int calculLoyer(Joueur j){
        return 0;
    }
}