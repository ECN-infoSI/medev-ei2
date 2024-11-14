/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly;

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

    /**
     * Effectue le paiement de x au Joueur j
     * @param joueur Joueur à payer
     * @param somme Montant à payer
     */
    public void paiement(Joueur adversaire, Integer somme) {
        
        try{
            if (fortune >= somme){
                        fortune-=somme;
                        adversaire.setFortune(getFortune()+somme);
            }
        }
        catch(NoMoreMoney exc){
            System.out.println("vous n'avez pas assez d'argent");
        }
        
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


    private void actionCase(Integer valeurDe, Case case){
        if (case instanceof AllerPrison){
            enPrison = 3;
        } else if (case instanceof Achetable and case.getProprietaire() == null){
            if ((valeurDe)%2 == 1){
                this.achete(case);
            }
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

    private Boolean tourDeJeuAux(Integer nbLances) {
        int de1 = lanceLeDe();
        int de2 = lanceLeDe();
        Boolean finTour = (de1 != de2);

        if (nbLances == 3 && !finTour) {
            this.setEnPrison(3);
        } else if (this.getEnPrison()>0) {

        }

        //TODO faire des actions en fonction de la case (proprio...)
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
        System.out.println("Le joueur " + this.getNom() + " est en " + this.getPosition().getPosition());
    }
}
