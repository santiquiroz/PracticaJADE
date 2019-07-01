/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author santi
 */
public class ComportamientoRecomendador extends TickerBehaviour{

    public ComportamientoRecomendador(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        System.out.println("Huy que estoy recomendando algo al cliente, nada sospechoso.");}
    
}
