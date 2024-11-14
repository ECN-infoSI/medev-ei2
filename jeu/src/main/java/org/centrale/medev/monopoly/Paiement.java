/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly;

public class Paiement extends Evenement {
    
    public int prix ;
    
    public Paiement(String nom, int position, int prix){
        super(position,nom) ;
        this.prix = prix ;
    }
    
    public Paiement(){
        super() ;
        this.prix = 2000 ;
    }
    
    public Paiement(Paiement p){
        super(p);
        this.prix = p.prix ;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public int getPosition() {
        return position;
    }

    public String getNom() {
        return nom;
    }
    
    
}
