package Comportamientos;

import actores.Regadera;
import agentes.AgenteAutomatizador;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ComportamientoAutomatizacion extends TickerBehaviour{
 
        Regadera regadera;
        Double cantidadAgua,radiacionSolar;
        Agent agente;
 
        public ComportamientoAutomatizacion(Agent a, long intervalo){
            super(a, intervalo);
            agente = a;
            regadera = ((AgenteAutomatizador)a).regadera;
        }
 
        protected void onTick() {
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