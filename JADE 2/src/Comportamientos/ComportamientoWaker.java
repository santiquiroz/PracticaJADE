package Comportamientos;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class ComportamientoWaker extends WakerBehaviour{
 
        int minticks;
 
        public ComportamientoWaker(Agent a, long intervalo){
            super(a, intervalo);
            minticks = 0;
        }
 
    
 
        protected void onWake() {
            System.out.println("hola");
        }
    }