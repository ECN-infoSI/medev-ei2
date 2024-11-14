/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.medev.monopoly;

/**
 *
 * @author EI2
 * 
 */
public class Case {
    
    private String nom; 
    private int position;

    public Case(String nom, int position){
        this.nom = nom;
        this.position = position;
    }
    public Case(){
        this.nom = "";
        this.position = 0;
    }

    public String toString(){
        String msg = this.nom ;
        if(this instanceof Achetable){
            msg = msg + "coût : " + String.valueOf(this.prix) + " - " ;
            if (this.proprietaire == None){
                msg = msg + "sans propriétaire";
            }
            else {
                msg = msg + "propriétaire : " + this.proprietaire.nom + " - " + "fortune : " + String.valueOf(this.proprietaire.fortune); 
            }
        }
        System.out.println(msg);
    }
}
