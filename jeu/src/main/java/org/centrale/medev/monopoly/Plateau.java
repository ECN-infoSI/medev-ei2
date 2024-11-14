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
    
    public Plateau() throws FileNotFoundException {
        plateau = new ArrayList<Case>();
        joueurs = new LinkedList<Joueur>();
        initPlateau();
    }
    
    public void initPlateau() throws FileNotFoundException{
        System.out.println("Inserez le nombre de joueurs: ");
        Scanner sc = new Scanner(System.in);
        
        try {
        
            int nbJoueurs = sc.nextInt();

            while (nbJoueurs < 2 || nbJoueurs > 10) {
                System.out.println("Le minimum de joueurs est 2 et le maximum est 10. \nInserez le nombre de joueurs: ");
                nbJoueurs = sc.nextInt();           
            }
            
            for (int i = 0; i < nbJoueurs; i++) {
                Joueur j = new Joueur();
                joueurs.add(j);
            }
            
            String fileName = "Liste_Cases.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch(NumberFormatException e) {
            System.out.println("Il faut inserer un numéro.");
        }
            
    }
    
    public int nbGares(Joueur j) {
        return 0;
    } 
    
    public void affiche(){
        
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
