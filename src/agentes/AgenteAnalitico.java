package agentes;

import jade.core.Agent;

public class AgenteAnalitico extends Agent {
    protected void setup() {
        String argumentos;
        Object[] args = getArguments();
        argumentos =args[0].toString();
        
        if (argumentos.equals("terminar agente")){            
            System.out.println("terminando agente");   
            doDelete();
        }
        
        System.out.println("El " + getAID().getName() + " esta ejecutandose.");
    }
}