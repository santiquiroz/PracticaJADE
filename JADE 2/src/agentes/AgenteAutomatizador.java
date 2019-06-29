package agentes;

import Comportamientos.ComportamientoAutomatizacion;
import actores.Regadera;
import jade.core.Agent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static java.lang.Thread.sleep;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteAutomatizador extends Agent {
    public Regadera regadera;
    Double cantidadAgua,radiacionSolar;
    
    protected void setup() {
        
        
        String argumentos;
        Object[] args = getArguments();
        argumentos =args[0].toString();
        
        if (argumentos.equals("terminar agente")){
            try {
                sleep(20000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AgenteAutomatizador.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("terminando agente");   
            doDelete();
        }
        if(argumentos.equals("dispositivo regadora")){
            this.regadera = new Regadera();
            addBehaviour(new ComportamientoAutomatizacion(this,1000) );
        }
        //Mensaje de inicializado
        System.out.println("El agente: " + getAID().getName() + " esta listo.");
    }
    
}
