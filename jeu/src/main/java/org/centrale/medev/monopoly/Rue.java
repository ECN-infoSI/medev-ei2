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
        if (this.proprietaire.getFortune() >= nbMConstruite*150 && nbMConstruite <= 4){
            int newNbM = this.getNbM() + nbMConstruite;
            this.setNbM(newNbM);
            int newFortune = this.proprietaire.getFortune() - nbMConstruite*150;
            this.proprietaire.setFortune(newFortune);
            System.out.println(this.proprietaire.getNom()+" a construit "+nbMConstruite+" maison(s).");
        } else {
            System.out.println("Le nombre de maisons rentrées n'est pas correct");
        }
    }
    
    public void construireHotel(int nbHConstruit){
        int cout = 1000 - this.nbM*200;
        if (this.proprietaire.getFortune() >= cout && nbHConstruit == 0){
            this.setNbH(1);
            this.setNbM(0);
            int newFortune = this.proprietaire.getFortune() - cout;
            this.proprietaire.setFortune(newFortune);
            System.out.println(this.proprietaire.getNom()+" a construit un hôtel.");
        } else {
            System.out.println("Le nombre d'hôtel rentré n'est pas correct");
        }
    }
    
    public int calculLoyer(){
        int a = 200;
        int b = 1200;
        int base = 100;
        int loyer = this.getNbH()*a + this.getNbM()*b;
        if (loyer==0){loyer = base;}
        return loyer;
    }
    
}
