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
        return msg;
    }

    public String getNom(){
        return this.nom;
    }

    public int getPosition(){
        return this.position;
    }

    public void setNom(String n){
        this.nom = n ;
    }

    public void setPosition(int n){
        this.position = n ;
    }
}
