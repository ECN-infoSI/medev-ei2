package org.centrale.medev.monopoly ;
    
public class Evenement extends Case{
    
    public Evenement(int position, String nom){
        super(position,nom);
    }
    public Evenement(){
        super() ;
    }
    public Evenement(Evenement e){
        super(e) ;
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
