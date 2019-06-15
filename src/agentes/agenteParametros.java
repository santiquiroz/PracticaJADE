package agentes;


import jade.core.Agent;

public class agenteParametros extends Agent {
    protected void setup() {
        String argumentos;
        Object[] args = getArguments();
        if (args != null && args.length > 0){
            argumentos =args[0].toString();
            System.out.println(argumentos);         
        }
       
    }
}