/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monopoly;

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
}
