/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;

 
import jade.core.Agent;
import jade.core.behaviours.*;
 
public class AgenteBreak extends Agent{
 
    // Inicialización del agente
    protected void setup()
    {
        addBehaviour( new MiComportamiento() );
    }
 
    // Finalización del agente
    protected void takeDown()
    {
        System.out.println("****Agente finalizado****");
    }
 
    // Definición de un comportamiento
    private class MiComportamiento extends Behaviour
    {
        int numeroEjecuciones = 1;
 
        // // Función que realiza MiComportamiento
        public void action()
        {
            System.out.println("Esta es la ejecucion: " + numeroEjecuciones);
 
            //lo bloqueamos durante un segundo
            block(1000);
            System.out.println("Despues de 1000 milisengundos");
            numeroEjecuciones++;
        }
 
        // Comprueba si el comportamiento ha finalizado
        public boolean done(){
            if(numeroEjecuciones>10)
            {
                myAgent.doDelete();
                return true;
            }
            else return false;
        }
    }
}
