
package Comportamientos;

import jade.core.Agent;
import jade.core.behaviours.*;
 
public class Agentecyclic extends Agent{
 
    public void setup() {
        MyOneShotBehaviour c = new MyOneShotBehaviour();
        addBehaviour(c);
    }
 
    protected void takeDown(){
        System.out.println("Ejecucion finalizada");
    }
 
    private class MyOneShotBehaviour extends CyclicBehaviour {
        public void action() {
           System.out.println("Solo se dispara una vez el comportamiento...");
           //myAgent.doDelete();
         }
    }
}//
