
package agentes;

import Comportamientos.ComportamientoX;
import jade.core.Agent;

/**
 *
 * @author santi
 */
public class AgenteX extends Agent{
    protected void setup(){
        Object[] args = getArguments();
        String argumentos = args[0].toString();
        if (argumentos.equals("terminar agente")){            
            System.out.println("terminando agente");   
            doDelete();
        }
        addBehaviour(new ComportamientoX(this) );
        System.out.println("El " + getAID().getName() + " esta ejecutandose.");
    
    }
}
