/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.medev.monopoly;

/**
 * Script Principal du jeu
 * @author simon
 */
public class Jeu {
    public static void main(String[] args) {
        Plateau plateau = new Plateau();
	    
	plateau.initPlateau();
	plateau.tourDeJeu();

	System.out.println("Fin de la partie, merci d'avoir utilisé notre jeu !");
    }
}
