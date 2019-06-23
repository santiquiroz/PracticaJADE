package agentes;

import jade.core.Agent;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteRecomendador extends Agent {
    protected void setup() {
        String argumentos;
        Object[] args = getArguments();
        argumentos =args[0].toString();
        
        if (argumentos.equals("terminar agente")){            
            System.out.println("terminando agente");   
            try {
                sleep(2000000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AgenteRecomendador.class.getName()).log(Level.SEVERE, null, ex);
            }
            doDelete();
        }
        System.out.println("Los argumentos son los siguientes: \n");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i].toString());
        }
        System.out.println("El " + getAID().getName() + " esta ejecutandose.");
    }
}