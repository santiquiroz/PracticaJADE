/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;
import jade.core.Agent;
import jade.core.behaviours.*;
 
public class agenteComportamiento2 extends Agent {
 
    // Inicialización del agente
    protected void setup(){
        // Añadir un comportamiento.
        addBehaviour(new MiComportamiento());
    }
 
    // Definición de un comportamiento
    private class MiComportamiento extends Behaviour{
 
        // Este método se ejecuta justo antes de la ejecución del método action()
        public void onStart()
        {
            System.out.println("Esto se hace cada vez que se inicia el comportamiento");
        }
 
        // Funcion a realizar por el comportamiento
        public void action(){
 
            System.out.println("Hola a todos.");
 
            //lo bloqueamos durante un segundo
            block(1000);
            System.out.println("Despues de 1 segundo");
        }
 
        // Comprueba si el comportamiento ha finalizado
        public boolean done(){
            return false;
        }
 
        // Se ejecuta antes de finalizar el comportamiento
        public int onEnd(){
            // Hace que el comportamiento se reinicie al finalizar.
            //myAgent.addBehaviour(this);
            myAgent.removeBehaviour(this);
            return 0;
        }
    }
}