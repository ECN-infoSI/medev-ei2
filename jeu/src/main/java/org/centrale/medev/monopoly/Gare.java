/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monopoly;

/**
 *
 * @author Thomas
 * 
 */
public class Gare {

    public Gare(){
        super();
    }

    public Gare(string n, int pos){
        super(n, pos);
    }

    public int calculLoyer(Plateau p, Joueur j){
        return 2500*p.nbGares(j)
    }
    

}