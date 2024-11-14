/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly;
/**
 *
 * @author Clara
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;



public class Plateau {
    private ArrayList<Case> plateau;
    private LinkedList<Joueur> joueurs;
    private int potCommun;
    
    public Plateau() throws IOException {
        plateau = new ArrayList<Case>();
        joueurs = new LinkedList<Joueur>();
        potCommun = 0;
        initPlateau();
    }
    
    public void initPlateau() throws FileNotFoundException, IOException{
        System.out.println("Inserez le nombre de joueurs: ");  
        
        try {
            Scanner sc = new Scanner(System.in);
            int nbJoueurs = sc.nextInt();

            while (nbJoueurs < 2 || nbJoueurs > 10) {
                System.out.println("Le minimum de joueurs est 2 et le maximum est 10. \nInserez le nombre de joueurs: ");
                nbJoueurs = sc.nextInt();           
            }
            
            sc = new Scanner(System.in);
            for (int i = 0; i < nbJoueurs; i++) {
                System.out.println("Inserez le nom du joueur " + (i+1) + ": ");
                String nomJoueur = sc.nextLine();
                Joueur j = new Joueur(nomJoueur);
                joueurs.add(j);
            }
            
            InputStream inputStream = Plateau.class.getResourceAsStream("/Liste_Cases.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en dos partes: nombre de clase y atributo nombre
                    String[] parties = line.split(" ");
                    if (parties.length >= 3) {
                        String className = parties[0];
                        String caseNom = parties[1];
                        int position = Integer.parseInt(parties[2]);
                        if (null != className) switch (className) {
                            
                            case "Gare" -> {
                                int valeur = Integer.parseInt(parties[3]);
                                Gare n = new Gare(caseNom, position, valeur);
                                plateau.add(n);
                                }
                            case "Rue" -> {
                                int valeur = Integer.parseInt(parties[3]);
                                Rue n = new Rue(caseNom, position, valeur);
                                plateau.add(n);
                                }
                            case "Compagnie" -> {
                                int valeur = Integer.parseInt(parties[3]);
                                Compagnie n = new Compagnie(caseNom, position, valeur);
                                plateau.add(n);
                                }
                            case "Prison" -> {
                                Prison n = new Prison(position);
                                plateau.add(n);
                                }
                            case "Payement" -> {
                                int valeur = Integer.parseInt(parties[3]);
                                Payement n = new Payement(caseNom, position, valeur);
                                plateau.add(n);
                                }
                            case "Carte" -> {
                                Carte n = new Carte(caseNom, position);
                                plateau.add(n);
                                }
                            case "AllerPrison" -> {
                                AllerPrison n = new AllerPrison(position);
                                plateau.add(n);
                                }
                            default -> {
                            }
                        }
                    } 
                    
                }
            
        } catch(NumberFormatException e) {
            System.out.println("Il faut inserer un numéro.");
        }                  
    }
    

    public int nbGare(Joueur j) {
        int count = 0;
        for (Case c : plateau) {
            // Check if the case is an instance of Gare
            if (c instanceof Gare) {
                Gare gare = (Gare) c; // Cast to Gare
                // Check if the owner of this Gare is the specified player
                if (gare.getProprietaire() == j) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void affiche() {
        System.out.println("=== État du Plateau ===");

        // Display Cases on the Plateau
        System.out.println("Cases du plateau:");
        for (Case c : plateau) {
            System.out.println(" - " + c.toString());
        }

        // Display Players
        System.out.println("\nJoueurs:");
        for (Joueur j : joueurs) {
            System.out.println(" - " + j.toString());
        }

        // Display Pot Commun
        System.out.println("\nPot Commun: " + potCommun + "€");
    }
    
    public Case avance(Case c, int d){
        return c;
    }

    public boolean finDePartie(){
        return false;
        
    }

    public void tourDeJeu(){
        
    }



}
