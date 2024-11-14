/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly;

import org.centrale.medev.monopoly.NoMoreMoneyException;

/**
 *
 * @author hanss
 */
public class Joueur {
    /**
     * Nom du joueur
     */
    private String nom;
    /**
     * Fortune du joueur
     */
    private Integer fortune;
    /**
     * Plateau associé au joueur
     */
    private Plateau plateau;
    /**
     * Position du joueur sur le plateau
     * Le plateau compte 40 cases
     */
    private Case position;
    /**
     * Temps restant immobilisé en prison
     */
    private Integer enPrison;

    /**
     * Constructeur d'un Joueur
     * @param nom Nom du nouveau Joueur
     * @param plateau Plateau lié au nouveau Joueur
     * 
     * On initialise :
     *  - fortune : 100000
     *  - position : 
     *  - enPrison : 0
     */
    public Joueur(String nom, Plateau plateau) {
        this.nom = nom;
        this.fortune = 100000;
        this.plateau = plateau;
        this.position = plateau.getPlateau().get(0);
        this.enPrison = 0;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getFortune() {
        return this.fortune;
    }

    public void setFortune(Integer fortune) {
        this.fortune = fortune;
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Case getPosition() {
        return this.position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public void setPosition(Integer position) {
        this.setPosition(this.getPlateau().get(position));
    }

    public Integer getEnPrison() {
        return this.enPrison;
    }

    public void setEnPrison(Integer enPrison) {
        this.enPrison = enPrison;
    }

    /**
     * Renvoie le nombre de gares possédées par le joueur
     * @return Nombre de gares possédées
     */
    public Integer nbGares() {
        return plateau.nbGares(this);
    }

    
    public void paiement(int somme) throws NoMoreMoneyException{
        if (fortune >= somme){
            fortune-=somme;
        }
        else{
            throw new NoMoreMoneyException("Pas assez d'argent");
        }
    }

    
    
    /**
     * Effectue le paiement de x au Joueur j
     * @param joueur Joueur à payer
     * @param somme Montant à payer
     */
    public void paiement(Joueur adversaire, Integer somme) throws NoMoreMoneyException {
        paiement(somme);
        adversaire.setFortune(adversaire.getFortune()+somme);
    }

    
    /**
     * Lance un dé à 6 faces
     * @return 1d6
     */
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }

    /**
     * Fait avancer le Joueur de valeurDe cases
     * @param valeurDe Nombre de cases
     */
    private void nouvellePos(Integer valeurDe) {
        this.setPosition(plateau.avance(this.getPosition(), valeurDe));
    }


    private void actionCase(Integer valeurDe, Case case_action){
        if (case_action instanceof Evenement){
            case_action.effet(this);
        } else if (case_action instanceof Achetable && case_action.getProprietaire() == null){
            if ((valeurDe)%2 == 1){
                this.achete(case_action);
            } else if (case_action instanceof Achetable and case_action.getProprietaire()!=null){
            this.payeLoyer((Achetable)case_action);
        }
    }
    /**
     * Gère le tour de jeu d'un Joueur
     */
    public void tourDeJeu() {
        Boolean finTour = false;
        int nbLances = 0;
        
        while (!finTour){
            nbLances += 1;
            finTour = tourDeJeuAux(nbLances);
        }
        
    }

    public void goToPrison() {
        this.setEnPrison(3);
        this.setPosition(10);
    }

    private Boolean tourDeJeuAux(Integer nbLances) {
        int de1 = lanceLeDe();
        int de2 = lanceLeDe();
        int tot = de1 + de2;
        Boolean finTour = (de1 != de2);

        if (nbLances == 3 && !finTour) {
            this.goToPrison();
            return true;
        } else if (this.getEnPrison()>0) {
            if (!finTour) {
                this.nouvellePos(tot);
            }
        } else {
            this.nouvellePos(tot);
        }
        actionCase(tot, this.position);
        
        return finTour;
    }
    /**
     * Permet au joueur de payer le loyer au joueur de la case sur laquelle il est tombe si elle a un proprietaire
     * @param caseOccupee correspond a la case sur laquelle se situe le joueur et qu'elle appartient a un autre joueur
     */
    public void payeLoyer(Achetable caseOccupee){
        this.paiement(caseOccupee.getPropritaire(),caseOccupee.calculLoyer());
    }
    /**
     * Permet d'acheter une case lorsque le joueur a une fortune assez grande
     * @param caseOccupee  correspond a la case sur laquelle se situe le joueur et qu'elle n'appartient a personne
     */
    public void achete(Achetable caseOccupee){
        int prix = caseOccupee.getPrix();
        
        if (this.fortune >= prix){
            this.fortune-=prix;
            caseOccupee.setProprietaire(this);
        }
        
    }
    

    /**
     * Affiche la position du Joueur
     */
    public void affiche() {
        System.out.println("Le joueur " + this.getNom() + " est en " + this.getPosition());
    }

    @Override
    public String toString() {
        String string = "nom='" + nom +
                ", fortune=" + fortune +
                ", position=" + position.toString();
        if (enPrison>0){
            return string+"En prison pour "+enPrison+" tours";
        }else{
            return string;
        }
    }
}
