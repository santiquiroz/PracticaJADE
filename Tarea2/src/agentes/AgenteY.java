
package agentes;
import Comportamientos.ComportamientoX;
import Comportamientos.ComportamientoY;
import jade.core.Agent;
/**
 *
 * @author santi
 */
public class AgenteY extends Agent{
    protected void setup(){
        Object[] args = getArguments();
        String argumentos = args[0].toString();
        if (argumentos.equals("terminar agente")){            
            System.out.println("terminando agente");   
            doDelete();
        }
        addBehaviour(new ComportamientoY(this,4000) );
        System.out.println("El " + getAID().getName() + " esta ejecutandose.");
    
    }
}
