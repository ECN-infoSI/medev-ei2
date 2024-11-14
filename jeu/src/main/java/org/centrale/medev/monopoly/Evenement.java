package org.centrale.medev.monopoly ;
    
public class Evenement extends Case{
    
    public Evenement(int position, String nom){
        super(nom, position);
    }
    public Evenement(){
        super() ;
    }


    public int getPosition() {
        return getPosition();
    }

    public String getNom() {
        return getNom();
    }

    public void setPosition(int position) {
        this.setPosition(position);
    }

    public void setNom(String nom) {
        this.setNom(nom);
    }

    public void effet(Joueur joueur) throws NoMoreMoneyException {

    }
}
