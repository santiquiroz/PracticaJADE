
package Comportamientos;
import jade.core.Agent;
import jade.core.behaviours.*;
 
public class agenteWaker extends Agent{
 
    long tini;
 
    protected void setup(){
        tini = System.currentTimeMillis();
        addBehaviour(new miWaker(this, 5000));
    }
 
    private class miWaker extends WakerBehaviour{
 
        int minticks;
 
        public miWaker(Agent a, long intervalo){
            super(a, intervalo);
            minticks = 0;
        }
 
    
 
        protected void onWake() {
            System.out.println("hola");
        }
    }
}