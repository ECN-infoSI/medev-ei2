/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.medev.monopoly;

/**
 *
 * @author titou
 * 
 */
public class Rue extends Achetable{
    
    private int nbM;
    private int nbH;

    public Rue() {
        super();
        this.nbM = 0;
        this.nbH = 0;
    }

    public int getNbM() {
        return nbM;
    }

    public int getNbH() {
        return nbH;
    }

    public void setNbM(int nbM) {
        this.nbM = nbM;
    }

    public void setNbH(int nbH) {
        this.nbH = nbH;
    }
    
    public void construireMaison(int nbMConstruite){
        int newNbM = this.getNbM() + nbMConstruite;
        this.setNbM(newNbM);
    }
    
    public void construireHotel(int nbHConstruite){
        int newNbH = this.getNbH() + nbHConstruite;
        this.setNbH(newNbH);
    }
    
    public int calculLoyer(){
        int a = 200;
        int b = 1000;
        int base = 100;
        int loyer = this.getNbH()*a + this.getNbM()*b;
        if (loyer==0){loyer = base;}
        return loyer;
    }
    
}
