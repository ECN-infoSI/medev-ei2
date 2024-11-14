package org.centrale.medev.monopoly ;

public class AllerPrison extends Evenement{
    private Joueur joueur ;
    
    public AllerPrison(String nom, int position){
        super(position,nom) ;
    }
    
    public AllerPrison(){
        super() ;
    }
    
    public AllerPrison(AllerPrison ap){
        super(ap) ;
    }
    
    public void effet(){
        joueur.goToPrison();
    }
    
}
