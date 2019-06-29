/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;

import jade.core.behaviours.Behaviour;

/**
 *
 * @author santi
 */
public class ComportamientoNormie extends Behaviour{

    @Override
    public void action() {
        System.out.println("me cago en la puta de oro");
    }

    @Override
    public boolean done() {
        System.out.println("odio mi bidada");
        return true;
    }
    
}
