package org.centrale.medev.monopoly;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public class NoMoreMoneyException extends Exception {
    public NoMoreMoneyException(String error){
	super(error);
	}
}
