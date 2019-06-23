package agentes;

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
        System.out.println("Los argumentos son los siguientes: \n");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i].toString());
        }
        System.out.println("El " + getAID().getName() + " esta ejecutandose.");
    }
}