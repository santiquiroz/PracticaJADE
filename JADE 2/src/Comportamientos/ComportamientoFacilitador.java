
package Comportamientos;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class ComportamientoFacilitador extends TickerBehaviour{
    int solicitar_datos_organizacion=0,
            solicitar_datos=0,
            solicitar_datos_usuario=0;
    boolean cambios;

    public ComportamientoFacilitador(Agent a, long period) {
        super(a, period);
    }
    protected void onTick() {
        leerPercepciones();
        if (solicitar_datos==1) {
            System.out.println("Entregando datos completos: \n");
            solicitar_datos=0;
            cambios = true;
        }
        if (solicitar_datos_usuario==1) {
            System.out.println("Entregando datos usuario: \n");
            solicitar_datos_usuario=0;
            cambios = true;
        }
        if (solicitar_datos_organizacion==1){
            System.out.println("Entregando datos organizacion: \n");
            solicitar_datos_organizacion=0;
            cambios = true;
        }
        if (cambios) {
            resetPercepts();
        }
        
    }
    public void resetPercepts(){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try {
            fichero = new FileWriter("Percepts/perceptsAgenteFacilitador.txt");
            escritor = new PrintWriter(fichero);
            escritor.flush();
            
            String cadena = "";
            FileReader entrada = null;
            try {
                entrada = new FileReader("Percepts/perceptsAgenteFacilitador.txt");
                int c;
                while((c = entrada.read()) != -1){
                    cadena += (char)c;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al leer archivo: "+e.getMessage());
            }
            
            //reiniciando valores a 0
            
            cadena.replace("1", "0");
            
            escritor.write(cadena);
            
            escritor.close();
        } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de texto: "+e.getMessage());
    } finally {
        if(fichero != null){
            try {
                fichero.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar archivo de texto: "+e.getMessage());
            }
        }
    }
    }
    public void leerPercepciones(){
        //se define la base de datos a leer
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File ("Percepts/perceptsAgenteFacilitador.txt");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String linea;
                String[] variable;
                while((linea=br.readLine())!=null){
                    variable = linea.split("=");
                    if(variable[0].equals("solicitar datos")){
                        solicitar_datos = Integer.parseInt(variable[1]);
                    }
                    if(variable[0].equals("solicitar datos organizacion")){
                        solicitar_datos_organizacion = Integer.parseInt(variable[1]);
                    }
                    if(variable[0].equals("solicitar datos usuario")){
                        solicitar_datos_usuario = Integer.parseInt(variable[1]);
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

                  

               }catch (Exception e2){ 
                  e2.printStackTrace();
               }
            }
    }

    
}
