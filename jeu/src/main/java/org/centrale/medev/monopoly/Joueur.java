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
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }
}
