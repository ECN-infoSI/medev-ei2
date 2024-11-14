package org.centrale.medev.monopoly;

public class Paiement extends Evenement {
    
    public int prix ;
    
    public Joueur joueur ;
    
    public Paiement(String nom, int position, int prix){
        super(position, nom);
        this.prix = prix ;
    }

    public Paiement(){
        super() ;
        this.prix = 2000 ;
    }
    
    public void effet() throws NoMoreMoneyException {
        joueur.paiement(prix) ;
    }
    
    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }
    
}
