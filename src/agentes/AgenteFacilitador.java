package agentes;


import jade.core.Agent;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteFacilitador extends Agent {
    protected void setup() {
        String argumentos, destinatario;
        Object[] args = getArguments();
        argumentos=args[0].toString();
        if (argumentos.equals("terminar agente")){
            try {
                sleep(20000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AgenteFacilitador.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("terminando agente");   
            doDelete();
        }
        if (argumentos.equals("entregar")){
            System.out.println("Entregando datos");
            destinatario = args[1].toString();
            if (destinatario.equals("Organizacion")) {
                System.out.println("Enviando datos a la organizacion.");
            }
            else if (destinatario.equals("Usuario")) {
                System.out.println("Enviando datos al usuario.");
            }
            else{
                System.out.println("Hay un error!.");
            }
        }
       
    }
}