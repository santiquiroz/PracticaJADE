package agentes;

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
    Timer TimerConsultaDatos;
    TimerTask TaskConsultarDatos;
    Regadera regadera;
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
            TimerConsultaDatos= new Timer();
            TaskConsultarDatos = new TimerTask(){
            public void run(){

                consultarDatos();

            }
            };
            TimerConsultaDatos.scheduleAtFixedRate(TaskConsultarDatos,1000,8000);

        }
        
        
       
        //Mensaje de inicializado
        System.out.println("El agente: " + getAID().getName() + " esta listo.");
    }
    private void consultarDatos(){
        //se define la base de datos a leer
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("base.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String[] variable;
            while((linea=br.readLine())!=null){
                variable = linea.split("=");
                if(variable[0].equals("cantidad de agua")){
                    cantidadAgua = Double.parseDouble(variable[1]);
                }
                if(variable[0].equals("cantidad de radiacion solar")){
                    radiacionSolar = Double.parseDouble(variable[1]);
                }
            }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }
              
              if((radiacionSolar>55)&&(cantidadAgua<10)){
                  regadera.activar(true);
              }
              else{
                  regadera.activar(false);
              }
              
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
       
    }
}
