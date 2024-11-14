package org.centrale.medev.monopoly ;
    
public class Evenement extends Case{
    
    public Evenement(int position, String nom){
        super(nom, position);
    }
    public Evenement(){
        super() ;
    }


    public int getPosition() {
        return super.getPosition();
    }

    public String getNom() {
        return super.getNom();
    }

    public void setPosition(int position) {
        super.setPosition(position);
    }

    public void setNom(String nom) {
        super.setNom(nom);
    }

    public void effet(Joueur joueur) throws NoMoreMoneyException {

    }
}
