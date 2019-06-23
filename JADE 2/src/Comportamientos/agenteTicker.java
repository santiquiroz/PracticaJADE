/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;
import jade.core.Agent;
import jade.core.behaviours.*;
 
public class agenteTicker extends Agent{
 
    long tini;
    int minticks = 0;
 
    protected void setup(){
        tini = System.currentTimeMillis();
        addBehaviour(new miTicker(this, 3000));
    }
 
    private class miTicker extends TickerBehaviour{
 
        
 
        public miTicker(Agent a, long intervalo){
            super(a, intervalo);
            
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
}