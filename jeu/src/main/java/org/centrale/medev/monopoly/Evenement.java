/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medev_tp1;

/**
 *
 * @author PRO
 */
public class Evenement extends Case{
    
    public Evenement(int position, String nom){
        this.position = position ;
        this.nom = nom ;
    }
    public Evenement(){
        this.position = 0 ;
        this.nom = null ;
    }
    public Evenement(Evenement e){
        this.position = e.position ;
        this.nom = e.nom ;
    }

    public int getPosition() {
        return position;
    }

    public String getNom() {
        return nom;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
