/*
Las percepciones entregadas a este agente son por medio de el 
txt ubicado en Percepts/PerceptsAgenteFacilitador.txt
si =1 significa que estan pidiendo datos
 */
package Comportamientos;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class ComportamientoFacilitador extends TickerBehaviour {

    int solicitar_datos_organizacion = 0,
            solicitar_datos = 0,
            solicitar_datos_usuario = 0;
    boolean cambios, mensajeDatosVerificados;
    Agent agente;
    ACLMessage ms ;

    public ComportamientoFacilitador(Agent a, long period) {
        super(a, period);
        agente=a;
        mensajeDatosVerificados = false;
    }

    protected void onTick() {
        if (mensajeDatosVerificados) {
            leerPercepciones();
            String url = "DataBases/DATOSPROS.txt";
            if (solicitar_datos == 1) {
                System.out.println("Entregando datos completos: \n");
                System.out.println(leerArchivo(url));
                solicitar_datos = 0;
                cambios = true;
            }
            if (solicitar_datos_usuario == 1) {
                System.out.println("Entregando datos usuario: \n");
                System.out.println(leerArchivo(url).replaceAll("cantidad de agua=.*\n", "cantidad de agua=page dlc para verlo\n"));
                solicitar_datos_usuario = 0;
                cambios = true;
            }
            if (solicitar_datos_organizacion == 1) {
                System.out.println("Entregando datos organizacion: \n");
                System.out.println(leerArchivo(url).replaceAll("cantidad de radiacion solar=.\n", "cantidad de radiacion solar page dlc para verlo"));
                solicitar_datos_organizacion = 0;
                cambios = true;
            }
            if (cambios) {
                try {
                    resetPercepts();
                } catch (IOException ex) {
                    Logger.getLogger(ComportamientoFacilitador.class.getName()).log(Level.SEVERE, null, ex);
                }
                cambios = false;
            }
        }
        else{
            ms= agente.receive();
            if (ms != null) {
                mensajeDatosVerificados=true;
                System.out.println("Mensaje de verificacion de datos recibido. \n");
            } 
        }

    }

    public String leerArchivo(String url) {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String texto = "";
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(url);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea = "puta vida";
            while ((linea = br.readLine()) != null) {
                texto = texto + linea + '\n';
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return texto;

    }

    public void resetPercepts() throws IOException {
        String nameDBDepurada = "Percepts/PerceptsAgenteFacilitador.txt";
        PrintWriter outputStream;
        String texto = leerArchivo(nameDBDepurada);
        texto = texto.replace('1', '0');
        try {
            outputStream = new PrintWriter(nameDBDepurada);

            outputStream.println(texto);  //Estos datos aun están solo en la ram
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void leerPercepciones() {
        //se define la base de datos a leer
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("Percepts/perceptsAgenteFacilitador.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String[] variable;
            while ((linea = br.readLine()) != null) {
                variable = linea.split("=");
                if (variable[0].equals("solicitar datos")) {
                    solicitar_datos = Integer.parseInt(variable[1]);
                }
                if (variable[0].equals("solicitar datos organizacion")) {
                    solicitar_datos_organizacion = Integer.parseInt(variable[1]);
                }
                if (variable[0].equals("solicitar datos usuario")) {
                    solicitar_datos_usuario = Integer.parseInt(variable[1]);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
