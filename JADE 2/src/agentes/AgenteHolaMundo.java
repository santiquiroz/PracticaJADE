package agentes;

import jade.core.Agent;

public class AgenteHolaMundo extends Agent {

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hola Mundo.. el agente: " + getAID().getName() + " esta listo.");
    }
}
