/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author santi
 */
public class ComportamientoX extends Behaviour{
    int ejecucionesExtrajudiciales=0;
    Agent agente;
    public ComportamientoX(Agent agente){
        super();
        this.agente =agente;
    }
    public void action() {
        System.out.println("Santiago Quiroz Upegui ft Ismael Restrepo Velez. \n");
        ejecucionesExtrajudiciales++;
    }

    @Override
    public boolean done() {
        if(ejecucionesExtrajudiciales==8){
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setContent("l lo sabes los shinigamis solo comen manzanas\n");
            msg.addReceiver(new AID("AgenteY",AID.ISLOCALNAME));
            agente.send(msg);
            return true;
        }
        return false;
    }
}
