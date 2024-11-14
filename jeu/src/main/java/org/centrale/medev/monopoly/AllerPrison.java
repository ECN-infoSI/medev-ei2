package org.centrale.medev.monopoly ;

public class AllerPrison extends Evenement{
    private Joueur joueur ;
    
    public AllerPrison(String nom, int position){
        super(position, nom);
    }
    
    public AllerPrison(){
        super() ;
    }
    
    public void effet(){
        joueur.goToPrison();
    }
    
}
