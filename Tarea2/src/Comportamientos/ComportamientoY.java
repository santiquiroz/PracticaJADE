/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author santi
 */
public class ComportamientoY extends TickerBehaviour{
    boolean mensajeObtenido;
    Agent agente;
    ACLMessage ms ;
    public ComportamientoY(Agent a, long period) {
        super(a, period);
        agente = a;
        mensajeObtenido = false;
    }

    @Override
    protected void onTick() {
        if (mensajeObtenido) {
            System.out.println(ms.getContent());
        }
        else {
           ms= agente.receive();
            if (ms != null) {
                mensajeObtenido=true;
                System.out.println("Mensaje recibido. \n");
            } 
        }
        
        
    }

    
    
}
