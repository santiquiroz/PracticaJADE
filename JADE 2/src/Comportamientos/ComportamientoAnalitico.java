/*
Las percepciones entregadas a este agente son por medio de el 
txt ubicado en Percepts/PerceptsAgenteAnalitico.txt
si ajuste=1 significa que estan ajuste
*/

package Comportamientos;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class ComportamientoAnalitico extends TickerBehaviour{
    Agent agente;
    int Ajuste;
    boolean cambio;
    static String urlDATOSPRO="DataBases/DATOSPROS.txt",urlSIATA="DataBases/external/SIATA.txt",urlPERCEPS="Percepts/PerceptsAgenteAnalitico.txt";
    
    public ComportamientoAnalitico(Agent a, long period) {
        super(a, period);
        agente=a;
        cambio = false;
        Ajuste = 0;
    }

    @Override
    protected void onTick() {
        leerPercepciones();
        if (Ajuste==1) {
            ajustar();
            Ajuste=0;
            cambio = true;
        }
        if (cambio) {
            try {
                resetPercepts();
            } catch (IOException ex) {
                Logger.getLogger(ComportamientoAnalitico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void ajustar(){
        
        String DATOSPROSdb = leerArchivo(urlDATOSPRO);
        
        String SIATAdb = leerArchivo(urlSIATA);
        
        if (!DATOSPROSdb.equals(SIATAdb)) {
            System.out.println("Las bases de datos no tienen los mismos datos");
        }
        else{
            System.out.println("Ajuste OK");
        }
        
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setContent("Datos Ajustados");
        msg.addReceiver(new AID("AgenteFacilitador",AID.ISLOCALNAME));
        msg.addReceiver(new AID("AgenteRecomendador",AID.ISLOCALNAME));
        agente.send(msg);
    }
    private void leerPercepciones() {
        String texto = leerArchivo(urlPERCEPS);
        String[] parametros=texto.split("\\n");
        String linea ="";
        for (String parametro : parametros) {
            linea = parametro;
            if((linea.split("=")[0]).equals("ajuste")){
                Ajuste=Integer.parseInt(linea.split("=")[1]);
            }
        }
    }
    public void resetPercepts() throws IOException {
        String nameDBDepurada = urlPERCEPS;
        PrintWriter outputStream;
        String texto = leerArchivo(nameDBDepurada);
        texto=texto.replace('1', '0');
        try {
            outputStream = new PrintWriter(nameDBDepurada);

            outputStream.println(texto);  //Estos datos aun están solo en la ram
            outputStream.close();
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public String leerArchivo(String url) {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String texto="";
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(url);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea = "puta vida";
            while ((linea = br.readLine()) != null) {
                texto=texto+linea+'\n';
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

    
    
}
