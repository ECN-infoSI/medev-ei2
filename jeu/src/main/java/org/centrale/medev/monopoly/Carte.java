package org.centrale.medev.monopoly ;

import java.util.Random;

public class Carte extends Evenement {
    
    private Joueur joueur ;
    
    public Carte(String nom, int position){
        super(nom, position) ;
    }
    
    public Carte(){
        super() ;
    }
    
    public void effet(){
        
        if (this.getNom() == "aller_a"){
            Random random = new Random() ;
            int x = random.nextInt(20)+1 ;
            joueur.setPosition(x);
            System.out.print("Vous avez été déplacé de "+x+" cases . \n Vous êtes à la case "+joueur.getPosition());
        }
        
        if (this.getNom() =="argent_plus"){
            Random random = new Random() ;
            int y = random.nextInt(500)+250 ;
            joueur.setFortune(joueur.getFortune()+y);
            System.out.print("Vous avez gagné "+y+ "euros. Votre fortune est de : " + joueur.getFortune()) ;
        }
        
        if (this.getNom() =="argent_moins"){
            Random random = new Random() ;
            int y = random.nextInt(500)+250 ;
            joueur.paiement(y) ;
            System.out.print("Vous avez perdu "+y+ "euros. Votre fortune est de : " + joueur.getFortune()) ;
        }

    }
    
}
