package agentes;


import Comportamientos.ComportamientoReceptor;
import jade.core.Agent;

public class AgenteReceptorDeDatos extends Agent {
    protected void setup() {
        String argumentos;
        Object[] args = getArguments();
        argumentos =args[0].toString();
        
        if (argumentos.equals("terminar agente")){            
            System.out.println("terminando agente");   
            doDelete();
        }
        System.out.println("Los argumentos del agente receptor son los siguientes: \n");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i].toString());
        }
        addBehaviour(new ComportamientoReceptor(this,10000) );
        System.out.println("El " + getAID().getName() + " esta ejecutandose.");
    }
}