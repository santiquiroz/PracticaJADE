package Comportamientos;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class ComportamientoLecturaDatos extends TickerBehaviour{
 
        long tini;
        int minticks =0 ;
 
        public ComportamientoLecturaDatos(Agent a, long intervalo){
            super(a, intervalo);
            tini = System.currentTimeMillis();
        }
 
        public void reset () {
            super.reset();
            //minticks = 0;
            System.out.println("reseteo!");
        }
 
        protected void onTick() {
            long tfin = System.currentTimeMillis() - tini;
            int nticks = getTickCount(); // obtenemos el numero de ticks desde el último reset
            minticks++;
            if (nticks == 5) {
                System.out.println("[" + tfin + "ms.] tick = " + nticks + ", mitick =  " + minticks + " y reseteo");
                reset();
            } else {
                System.out.println("[" + tfin + "ms.] tick = " + nticks + ", mitick =  " + minticks);
            }
        }
    }