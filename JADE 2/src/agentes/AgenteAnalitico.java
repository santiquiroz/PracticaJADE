package agentes;

import jade.core.Agent;
import Comportamientos.ComportamientoNormie;
import Comportamientos.ComportamientoTicker;
import Comportamientos.ComportamientoWaker;

public class AgenteAnalitico extends Agent {
    protected void setup() {
        String argumentos;
        Object[] args = getArguments();
        argumentos =args[0].toString();
        
        if (argumentos.equals("terminar agente")){            
            System.out.println("terminando agente");   
            doDelete();
        }
        addBehaviour(new ComportamientoNormie() );
        addBehaviour(new ComportamientoWaker(this,5000) );
        addBehaviour(new ComportamientoTicker(this,5000) );
        System.out.println("El " + getAID().getName() + " esta ejecutandose.");
    }
}